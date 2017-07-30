package com.palhambra.prodentalserver.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "activity")
	private List<WorkShift> workShiftList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WorkShift> getWorkShiftList() {
		return workShiftList;
	}

	public void setWorkShiftList(List<WorkShift> workShiftList) {
		this.workShiftList = workShiftList;
	}

}
