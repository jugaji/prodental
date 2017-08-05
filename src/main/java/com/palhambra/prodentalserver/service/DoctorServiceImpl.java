package com.palhambra.prodentalserver.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.palhambra.prodentalserver.model.Doctor;
import com.palhambra.prodentalserver.model.RoleEnum;
import com.palhambra.prodentalserver.repository.DoctorRepository;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Doctor createDoctor(Doctor doctor) {
		doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
		doctor.setRole(RoleEnum.Patient.getName());

		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor update(Doctor doctor) {
		doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
		doctor.setRole(RoleEnum.Patient.getName());

		return doctorRepository.save(doctor);
	}


	@Override
	public Doctor getDoctor(Long id) {
		return doctorRepository.findOne(id);
	}

	@Override
	public void deleteDoctor(Long id) {
		doctorRepository.delete(id);
	}
}
