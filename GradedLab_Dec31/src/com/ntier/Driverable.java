package com.ntier;


import java.util.List;

interface Driverable {

	void saveToStorage();

	String getZipCode();

	String getFirstName();

	String getLastName();

	String getID();

	List<Policy> getPolicies();

}
