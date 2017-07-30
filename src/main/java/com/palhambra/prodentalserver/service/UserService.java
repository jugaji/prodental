package com.palhambra.prodentalserver.service;

import com.palhambra.prodentalserver.model.User;

public interface UserService {

	User createUser(User user);

	User getUser(Long id);

	void deleteUser(Long id);

	User update(User user);

}
