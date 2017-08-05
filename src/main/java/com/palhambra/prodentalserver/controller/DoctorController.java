package com.palhambra.prodentalserver.controller;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.palhambra.prodentalserver.dto.DoctorDTO;
import com.palhambra.prodentalserver.model.Doctor;
import com.palhambra.prodentalserver.service.DoctorService;

@RestController
@RequestMapping(value = "/api/doctor")
public class DoctorController {
	
	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Autowired
	private DoctorService doctorService;

	@ResponseStatus(code = HttpStatus.CREATED)
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Doctor createDoctor(@RequestBody DoctorDTO doctorDto) {
		if (!doctorDto.getPassword().equals(doctorDto.getSecure_password())) {
			throw new NullPointerException();
		}

		Doctor doctor = dozerBeanMapper.map(doctorDto, Doctor.class);
		return doctorService.createDoctor(doctor);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Doctor updateDoctor(@RequestBody DoctorDTO doctorDto) {
		if (!doctorDto.getPassword().equals(doctorDto.getSecure_password())) {
			throw new NullPointerException();
		}

		Doctor doctor = dozerBeanMapper.map(doctorDto, Doctor.class);
		return doctorService.update(doctor);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Doctor getDoctor(@PathVariable(name = "id") Long id) {
		return doctorService.getDoctor(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteDoctor(@PathVariable(name = "id") Long id) {
		doctorService.getDoctor(id);
	}

}
