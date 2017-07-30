package com.palhambra.prodentalserver.repository;

import org.springframework.data.repository.CrudRepository;

import com.palhambra.prodentalserver.model.Appointment;
import com.palhambra.prodentalserver.model.AppointmentPK;

public interface AppointmentRepository extends CrudRepository<Appointment, AppointmentPK> {

}
