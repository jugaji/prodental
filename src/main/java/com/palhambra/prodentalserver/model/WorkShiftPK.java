package com.palhambra.prodentalserver.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class WorkShiftPK implements Serializable {

	private static final long serialVersionUID = 4615830644059347995L;

	private Date date;

	private Boolean morning;

	@Column(name = "cabinet_id")
	private Long cabinetId;

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
