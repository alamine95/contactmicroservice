package sn.cfoa.contactmicroservice.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import sn.cfoa.contactmicroservice.model.Role;
import sn.cfoa.contactmicroservice.model.User;

@Configuration
public class JwtTokenFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtTokenUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if(!hasAuthorizationBearer(request)) {
			filterChain.doFilter(request, response);
			return;
		}
		String accessToken = getAccessToken(request);
		
		if(jwtUtil.validateAccessToken(accessToken)) {
			filterChain.doFilter(request, response);
			return;
		}
		
		setAuthenticationContext(accessToken, request);
		filterChain.doFilter(request, response);
		
	}

	private void setAuthenticationContext(String accessToken, HttpServletRequest request) {
		UserDetails userDetails = getUserDetails(accessToken);
		
		
		UsernamePasswordAuthenticationToken authentication = new
				UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private UserDetails getUserDetails(String accessToken) {
		User userDetails = new User();
		Claims claims = jwtUtil.parseClaims(accessToken);
		String subject = (String) claims.get(Claims.SUBJECT);
		String roles = (String) claims.get("roles");
		
		System.out.println("roles: " +roles);
		
		roles = roles.replace("[", "").replace("]", "");
		String[] roleNames = roles.split(",");
		
		for(String aRoleName : roleNames) {
			userDetails.addRole(new Role(aRoleName));
		}
		String[] jwtSubject = subject.split(",");
		
		userDetails.setId(Integer.parseInt(jwtSubject[0]));
		userDetails.setEmail(jwtSubject[1]);
		
		return (UserDetails) userDetails;
	}

	private String getAccessToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		String token = header.split("")[1].trim();
		System.out.println("Access Token:" +token);
		return token;
	}

	private boolean hasAuthorizationBearer(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		System.out.println("Authorization header:" +header);
		if(ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
			return false;
		}
		return true;
	}

}
