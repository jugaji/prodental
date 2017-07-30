package com.palhambra.prodentalserver.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDTO  implements Serializable {

	private static final long serialVersionUID = 861263910733018401L;
	
	private String name;

	private String surrname;

	private String phone;

	private String mobile_phone;

	private String nif;

	private String nie;

	private Date birthdate;

	private String email;

	private String address;

	private String province;

	private String nationality;

	private String password;

	private String secure_password;

	private String captcha;

	public UserDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurrname() {
		return surrname;
	}

	public void setSurrname(String surrname) {
		this.surrname = surrname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNie() {
		return nie;
	}

	public void setNie(String nie) {
		this.nie = nie;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecure_password() {
		return secure_password;
	}

	public void setSecure_password(String secure_password) {
		this.secure_password = secure_password;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

}
