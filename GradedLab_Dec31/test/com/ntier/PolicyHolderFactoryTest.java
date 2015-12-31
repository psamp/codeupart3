package com.ntier;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PolicyHolderFactoryTest {

	@Test
	public void testGetInstance() {

		List<Policy> policies = new ArrayList<Policy>();
		List<String> vehicleUseList = new ArrayList<String>();

		vehicleUseList.add("Stuff");
		vehicleUseList.add("Smuggling");
		
		VehicleUse vu = new VehicleUse();
		
		vu.setVehicleUse(vehicleUseList);

		policies.add(InsurancePolicyFactory.getInstance(5L, "30331", 250.000, 70_000, 90_000, 85_000));
		policies.add(InsurancePolicyFactory.getInstance(6L, "41111", 300.000, 100_000, vu));

		assertTrue(PolicyHolderFactory.getInstance("Han", "Solo", "30331", policies) instanceof Driver);
	}

}
