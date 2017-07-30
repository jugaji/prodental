package com.palhambra.prodentalserver.repository;

import org.springframework.data.repository.CrudRepository;

import com.palhambra.prodentalserver.model.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Long> {

}
