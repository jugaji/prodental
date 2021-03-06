package com.palhambra.prodentalserver.repository;

import org.springframework.data.repository.CrudRepository;

import com.palhambra.prodentalserver.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByEmail(String email);

	public User findById(Long id);

}
