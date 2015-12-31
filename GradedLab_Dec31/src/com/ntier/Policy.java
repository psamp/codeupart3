package com.ntier;


import java.io.Serializable;

public class Policy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7147916943443709577L;
	private long id;
	private String zipCode;
	private double base;
	private double liabilityLimit;

	public Policy() {

	}

	public Policy(long id, String zipCode, double base, double liabilityLimit) {
		this.setId(id);
		this.setZipCode(zipCode);
		this.setBase(base);
		this.setLiabilityLimit(liabilityLimit);
	}

	@Override
	public String toString() {
		return "Policy " + id + ": \n" + zipCode  + "|" + base + "|" + liabilityLimit;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getLiabilityLimit() {
		return liabilityLimit;
	}

	public void setLiabilityLimit(double liabilityLimit) {
		this.liabilityLimit = liabilityLimit;
	}

}
