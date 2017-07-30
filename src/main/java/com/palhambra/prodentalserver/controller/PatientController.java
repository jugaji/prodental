package com.palhambra.prodentalserver.controller;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.palhambra.prodentalserver.dto.UserDTO;
import com.palhambra.prodentalserver.model.User;
import com.palhambra.prodentalserver.service.UserService;

@RestController
@RequestMapping(value = "/api/patient")
public class PatientController {
	
	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Autowired
	private UserService userService;

	@ResponseStatus(code = HttpStatus.CREATED)
	@RequestMapping(value = "", method = RequestMethod.POST)
	public User createUser(@RequestBody UserDTO userDto) {
		if (!userDto.getPassword().equals(userDto.getSecure_password())) {
			throw new NullPointerException();
		}

		User user = dozerBeanMapper.map(userDto, User.class);
		return userService.createUser(user);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public User updateUser(@RequestBody UserDTO userDto) {
		if (!userDto.getPassword().equals(userDto.getSecure_password())) {
			throw new NullPointerException();
		}

		User user = dozerBeanMapper.map(userDto, User.class);
		return userService.update(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable(name = "id") Long id) {
		return userService.getUser(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable(name = "id") Long id) {
		userService.getUser(id);
	}

}
