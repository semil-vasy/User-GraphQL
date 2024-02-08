package com.example.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.user.dto.UserDto;
import com.example.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@QueryMapping("allUsers")
	public List<UserDto> getAll() {
		return this.userService.getAllUsers();
	}

	@QueryMapping("getUser")
	public UserDto getById(@Argument long userId) {
		return this.userService.getUserById(userId);
	}

	@MutationMapping("createUser")
	public UserDto createUser(@Argument UserDto user) {
		return this.userService.createUser(user);
	}

	@MutationMapping("updateUser")
	public UserDto updateUser(@Argument long userId, @Argument UserDto user) {
		return this.userService.updateUser(user, userId);
	}

	@MutationMapping("deleteUser")
	public String deleteUser(@Argument long userId) {
		this.userService.deleteUser(userId);
		return "User Deleted Successfully";
	}
}
