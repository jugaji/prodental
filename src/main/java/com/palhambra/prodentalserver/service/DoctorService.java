package com.palhambra.prodentalserver.service;

import com.palhambra.prodentalserver.model.Doctor;

public interface DoctorService {

	Doctor createDoctor(Doctor doctor);

	Doctor update(Doctor doctor);

	Doctor getDoctor(Long id);

	void deleteDoctor(Long id);

}
