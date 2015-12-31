package com.ntier;


import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Driver extends PolicyHolder implements Serializable, Driverable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2176069406819922579L;
	private String ID;
	private String firstName;
	private String lastName;
	private String zipCode;
	private List<Policy> policies = new ArrayList<Policy>();

	public Driver() {

	}

	public Driver(String firstName, String lastName, String zipCode, List<Policy> policies) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setLastName(lastName);
		this.setZipCode(zipCode);
		this.setPolicies(policies);
		this.setID();
	}

	@Override
	public void saveToStorage() {

		try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Storage.xml")))) {
			encoder.writeObject(this);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Driver " + ID + ":");
		sb.append("\n" + firstName + " " + lastName + "|" + zipCode);
		sb.append("\n \n");
		
		for (Policy policy : policies) {
			sb.append(policy.toString());
			sb.append("\n \n");
		}
		
		return sb.toString();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<Policy> getPolicies() {
		return new ArrayList<Policy>(policies);
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	@Override
	public String getID() {
		return this.ID;
	}

	public void setID() {
		this.ID = this.getZipCode() + System.currentTimeMillis();
	}

}
