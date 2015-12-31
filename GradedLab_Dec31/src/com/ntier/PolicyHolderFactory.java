package com.ntier;


import java.util.ArrayList;
import java.util.List;

class PolicyHolderFactory {

	public static PolicyHolder getInstance(String firstName, String lastName, String zipCode, List<Policy> policies) {

		return new Driver(firstName, lastName, zipCode, PolicyHolderFactory.checkPolicyZipcode(policies, zipCode));
	}
	
	private static List<Policy> checkPolicyZipcode(List<Policy> policies, String zipcode) {
		
		List<Policy> p = new ArrayList<Policy>();

		for (Policy policy : policies) {
			if (zipcode.equals(policy.getZipCode())) {
				p.add(policy);
			}
		}

		if (p.size() == 0) {
			throw new IllegalArgumentException("Driver policies must match driver zipcode.");
		} else {
			return p;
		}
		
	}

}
