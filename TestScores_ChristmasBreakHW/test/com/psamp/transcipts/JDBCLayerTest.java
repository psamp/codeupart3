package com.psamp.transcipts;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class JDBCLayerTest {
	private JDBCLayer db;

	@Before
	public void setUp() {

		db = new JDBCLayer("agileTest");
	}

	@Test
	public void testGetAllFromCurrentTable() {

		List<Transcript> list = db.getAllFromCurrentTable();

		assertTrue(list != null);

		for (Transcript transcript : list) {
			assertTrue(transcript != null);
		}
	}

	@Test
	public void testThatProperTranscriptObjectsAreBeingBuilt() {

		List<Transcript> resultFromSearch = db.searchTableByID(1);
		Transcript result = resultFromSearch.get(0);

		assertEquals("lora", result.getFirstName());
		assertEquals("ipsum", result.getLastName());
		assertEquals("lora@gmail.com", result.getEmail());
		assertEquals("2011-10-12", result.getDateTaken());
		assertEquals(78, result.getGrade());
		assertEquals(true, result.passedTest());
	}

	@Test
	public void testPostNewTranscript() throws Exception {

		int actual = db.postNewTranscript("random", "name", "rndm@hotmail.com", "2015-08-05", 92);

		assertEquals(1, actual);
	}

}
