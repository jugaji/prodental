package com.palhambra.prodentalserver.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palhambra.prodentalserver.model.Appointment;
import com.palhambra.prodentalserver.repository.AppointmentRepository;

@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AppointmentRepository appointmentRepository;

	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	public List<Appointment> findAllAppointmentByIdUser(Long idUser) {
		return appointmentRepository.findAppointmentByUser_Id(idUser);
	}

	public Appointment findNextAppointmentByIdUser(Long idUser) {
		List<Appointment> appointmentList = appointmentRepository.findAppointmentByUser_Id(idUser);
		Appointment result = null;
		if (appointmentList != null && appointmentList.size() > 0) {
			Boolean found = Boolean.FALSE;
			int count = 0;
			Date now = new Date();

			while (!found && count < appointmentList.size()) {
				Appointment a = appointmentList.get(count);
				if (a.getAppointmentPK().getDate().after(now)) {
					found = Boolean.TRUE;
					result = a;
				}
			}
		}

		return result;
	}
}
