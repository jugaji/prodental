package com.palhambra.prodentalserver.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Appointment implements Serializable {

	private static final long serialVersionUID = -2059729285483393550L;

	@EmbeddedId
	private AppointmentPK appointmentPK;

	@MapsId
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "date"), @JoinColumn(name = "morning"), @JoinColumn(name = "cabinetId") })
	private WorkShift workShift;

	private Integer durationMinutes;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public AppointmentPK getAppointmentPK() {
		return appointmentPK;
	}

	public void setAppointmentPK(AppointmentPK appointmentPK) {
		this.appointmentPK = appointmentPK;
	}

	public Integer getDurationMinutes() {
		return durationMinutes;
	}

	public void setDurationMinutes(Integer durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	public WorkShift getWorkShift() {
		return workShift;
	}

	public void setWorkShift(WorkShift workShift) {
		this.workShift = workShift;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
