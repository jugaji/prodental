package com.palhambra.prodentalserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.palhambra.prodentalserver.model.RoleEnum;
import com.palhambra.prodentalserver.model.User;
import com.palhambra.prodentalserver.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(RoleEnum.Patient.getName());

		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(RoleEnum.Patient.getName());

		return userRepository.save(user);
	}

	@Override
	public User getUser(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.delete(id);
	}
}
