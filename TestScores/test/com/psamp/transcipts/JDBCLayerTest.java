package com.psamp.transcipts;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class JDBCLayerTest {
	private JDBCLayer db;

	@Before
	public void setUp() throws Exception {
		db = new JDBCLayer();
	}

	@Test
	public void testGetAllTranscripts() {
		List<Transcript> list = db.getAllTranscripts();

		assertTrue(list != null);

		for (Transcript transcript : list) {
			assertTrue(transcript != null);
		}

	}

}
