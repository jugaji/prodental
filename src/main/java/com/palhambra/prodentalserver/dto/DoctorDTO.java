package com.palhambra.prodentalserver.dto;

import java.io.Serializable;

public class DoctorDTO extends UserDTO implements Serializable {

	private static final long serialVersionUID = 861263910733018401L;
	
	private String speciality;

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

}
