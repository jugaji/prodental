package com.palhambra.prodentalserver.service;

import com.palhambra.prodentalserver.model.Appointment;
import com.palhambra.prodentalserver.model.User;

import javassist.NotFoundException;

public interface UserService {

	User createUser(User user);

	User getUser(Long id);

	void deleteUser(Long id);

	User update(User user);

	User addAppointment(Appointment appointment, Long idUser) throws NotFoundException;

}
