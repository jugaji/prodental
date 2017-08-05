package com.palhambra.prodentalserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.palhambra.prodentalserver.model.Appointment;
import com.palhambra.prodentalserver.model.RoleEnum;
import com.palhambra.prodentalserver.model.User;
import com.palhambra.prodentalserver.repository.UserRepository;

import javassist.NotFoundException;

@Service("userService")
public class UserServiceImpl implements UserService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
	public User addAppointment(Appointment appointment, Long idUser) throws NotFoundException {
		User user = userRepository.findById(idUser);
		if (user != null) {
			user.addAppointmentToList(appointment);
			return userRepository.save(user);
		} else {
			logger.error("User not found with id: " + idUser);
			throw new NotFoundException("User not found with id: " + idUser);
		}
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
