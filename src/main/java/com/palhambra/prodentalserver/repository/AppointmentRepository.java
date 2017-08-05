package com.palhambra.prodentalserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.palhambra.prodentalserver.model.Appointment;
import com.palhambra.prodentalserver.model.AppointmentPK;

public interface AppointmentRepository extends CrudRepository<Appointment, AppointmentPK> {

	public List<Appointment> findAppointmentByUser_Id(Long id);

	public List<Appointment> findAllAppointmentByUser_Id(Long id);
}
