package sn.cfoa.contactmicroservice.service;

import java.util.List;

import sn.cfoa.contactmicroservice.dto.UserDto;

public interface UserService {
	
	public UserDto addUser(UserDto userDto);
	public List<UserDto> getAllUsers();
	public UserDto updateUser(Integer userId, UserDto userDto);
	public String deleteUser(Integer userId);

}
