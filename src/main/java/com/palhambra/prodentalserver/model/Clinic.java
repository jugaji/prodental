package com.palhambra.prodentalserver.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Clinic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nombre;

	private String direccion;

	@OneToMany(mappedBy = "clinic")
	private List<Cabinet> cabinetList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Cabinet> getCabinetList() {
		return cabinetList;
	}

	public void setCabinetList(List<Cabinet> cabinetList) {
		this.cabinetList = cabinetList;
	}

}
