package sn.cfoa.contactmicroservice.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import sn.cfoa.contactmicroservice.dto.UserDto;
import sn.cfoa.contactmicroservice.model.Role;
import sn.cfoa.contactmicroservice.model.User;
import sn.cfoa.contactmicroservice.repository.RoleRepository;
import sn.cfoa.contactmicroservice.repository.UserRepository;
import sn.cfoa.contactmicroservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private RoleRepository roleRepository;
	
	@Resource
	private UserRepository userRepository;

	@Transactional
	@Override
	public UserDto addUser(UserDto userDto) {
		User user = new User();
		mapDtoToEntity(userDto, user);
		User saveUser = userRepository.save(user);
		return mapEntityToDto(saveUser);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> userDtos = new ArrayList<>();
		List<User> users = userRepository.findAll();
		users.stream().forEach(user -> {
			UserDto userDto = mapEntityToDto(user);
			userDtos.add(userDto);
		});
		return userDtos;
	}

	@Transactional
	@Override
	public UserDto updateUser(Integer userId, UserDto userDto) {
		@SuppressWarnings("deprecation")
		User std = userRepository.getOne(userId);
		std.getRoles().clear();
		mapDtoToEntity(userDto, std);
		User user = userRepository.save(std);
		return mapEntityToDto(user);
	}

	@Override
	public String deleteUser(Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		// remove the related roles from user entity
		if(user.isPresent()) {
			user.get().removeRoles();
			userRepository.deleteById(user.get().getId());
			return "User with id:" +userId+ "delete successfully";
		}
		return null;
	}
	
	public void mapDtoToEntity(UserDto userDto, User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setNom(userDto.getNom());
		user.setPrenom(userDto.getPrenom());
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		if(user.getRoles() == null) {
			user.setRoles(new HashSet<>());
		}
		userDto.getRoles().stream().forEach(rolenom -> {
			Role role = roleRepository.findByNom(rolenom);
			if(role == null) {
				role = new Role();
				role.setUsers(new HashSet<>());
			}
			role.setNom(rolenom);
			user.addRole(role);
		});
	}
	
	public UserDto mapEntityToDto(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		UserDto responseDto = new UserDto();
		responseDto.setId(user.getId());
		responseDto.setNom(user.getNom());
		responseDto.setPrenom(user.getPrenom());
		responseDto.setEmail(user.getEmail());
		responseDto.setPassword(passwordEncoder.encode(user.getPassword()));
		responseDto.setRoles(user.getRoles().stream().map(Role::getNom).collect(Collectors.toSet()));
		return responseDto;
	}

}
