package com.java.dto;

import java.io.Serializable;

public class GuestDTO implements Serializable {
	
	private Integer gno;
	private String name;
	private String address;
	private Double pdaycharge;
	private Integer noofdays;
	
	
	
	public Integer getGno() {
		return gno;
	}
	public void setGno(Integer gno) {
		this.gno = gno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getPdaycharge() {
		return pdaycharge;
	}
	public void setPdaycharge(Double pdaycharge) {
		this.pdaycharge = pdaycharge;
	}
	public Integer getNoofdays() {
		return noofdays;
	}
	public void setNoofdays(Integer noofdays) {
		this.noofdays = noofdays;
	}

	
	

}
