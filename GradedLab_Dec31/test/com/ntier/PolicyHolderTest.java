package com.ntier;

import static org.junit.Assert.assertEquals;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PolicyHolderTest {
	private PolicyHolder ph;

	@Before
	public void setUp() {
		List<Policy> policies = new LinkedList<Policy>();

		List<String> vuList = new ArrayList<String>();
		vuList.add("Shooting at Kylo Ren");
		vuList.add("Exploring");
		vuList.add("Crashing");

		VehicleUse vu = new VehicleUse();
		vu.setVehicleUse(vuList);

		policies.add(InsurancePolicyFactory.getInstance(8L, "30326", 250.000, 70_000, 90_000, 85_000));
		policies.add(InsurancePolicyFactory.getInstance(9L, "90008", 480.000, 120_000, 100_000, 95_000));
		policies.add(InsurancePolicyFactory.getInstance(6L, "30326", 100.000, 40_000, vu));
		policies.add(InsurancePolicyFactory.getInstance(2L, "41111", 300.000, 100_000, vu));

		ph = PolicyHolderFactory.getInstance("Rey", "Skywalker", "30326", policies);
	}

	@Test
	public void testThatPolicyHolderIsADriverableAndThatAllFieldsArePopulated() {

		Driverable cast = (Driverable) ph;

		assertEquals("30326", cast.getZipCode());
		assertEquals("Rey", cast.getFirstName());
		assertEquals("Skywalker", cast.getLastName());
		assertEquals(true, cast.getPolicies() != null);

	}

	@Test
	public void testThatOnlyPoliciesWithZipcodesThatMatchthePolicyHoldersAreSaved() {

		List<Policy> policies = ((Driverable) ph).getPolicies();

		for (Policy policy : policies) {
			assertEquals(policy.getZipCode(), ((Driverable) ph).getZipCode());
		}

	}

	@Test
	public void testSavetoStorageDriverImplementation() {

		Driverable cast = (Driverable) ph;
		Driverable result = null;

		cast.saveToStorage();

		try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("Storage.xml")))) {
			Object rtn = decoder.readObject();
			result = (Driverable) (Driver) rtn;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		assertEquals(cast.getFirstName(), result.getFirstName());
		assertEquals(cast.getLastName(), result.getLastName());
		assertEquals(cast.getZipCode(), result.getZipCode());
		assertEquals(cast.getPolicies().get(0).getBase(), result.getPolicies().get(0).getBase(), .001);
		assertEquals(cast.getPolicies().get(1).getBase(), result.getPolicies().get(1).getBase(), .001);

	}

}
