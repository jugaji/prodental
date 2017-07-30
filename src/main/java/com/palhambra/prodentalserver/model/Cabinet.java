package com.palhambra.prodentalserver.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cabinet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Integer number;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinic_id")
	private Clinic clinic;

	@OneToMany(mappedBy = "cabinet")
	private List<WorkShift> workShiftList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public List<WorkShift> getWorkShiftList() {
		return workShiftList;
	}

	public void setWorkShiftList(List<WorkShift> workShiftList) {
		this.workShiftList = workShiftList;
	}

}
