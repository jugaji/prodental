package com.palhambra.prodentalserver.repository;

import org.springframework.data.repository.CrudRepository;

import com.palhambra.prodentalserver.model.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
