package com.palhambra.prodentalserver.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class AppointmentPK implements Serializable {

	private static final long serialVersionUID = 7071280077243549988L;

	private Date time;

	private Date date;

	private Boolean morning;

	private Long cabinetId;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getMorning() {
		return morning;
	}

	public void setMorning(Boolean morning) {
		this.morning = morning;
	}

	public Long getCabinetId() {
		return cabinetId;
	}

	public void setCabinetId(Long cabinetId) {
		this.cabinetId = cabinetId;
	}


}
