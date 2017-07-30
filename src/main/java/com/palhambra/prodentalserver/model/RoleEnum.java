package com.palhambra.prodentalserver.model;

public enum RoleEnum {
	Patient("patient"), Doctor("doctor"), Admin("admin"), Aux("aux");

	private String name;

	RoleEnum(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
