package com.palhambra.prodentalserver.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class WorkShift implements Serializable {

	private static final long serialVersionUID = 694951847791599438L;

	@EmbeddedId
	private WorkShiftPK WorkShiftPK;

	@MapsId("cabinetId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cabinet_id")
	private Cabinet cabinet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "activity_id")
	private Activity activity;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_ID")
	private Doctor doctor;

	@OneToMany(mappedBy = "workShift")
	private List<Appointment> appointmentList;


	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	public WorkShiftPK getWorkShiftPK() {
		return WorkShiftPK;
	}

	public void setWorkShiftPK(WorkShiftPK workShiftPK) {
		WorkShiftPK = workShiftPK;
	}

	public Cabinet getCabinet() {
		return cabinet;
	}

	public void setCabinet(Cabinet cabinet) {
		this.cabinet = cabinet;
	}

}
