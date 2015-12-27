package com.psamp.transcipts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class JDBCLayer {
	private String dbURL = "jdbc:mysql://localhost/transcripts?user=root&password=rooty&useSSL=true";

	List<Transcript> getAllTranscripts() {

		List<Transcript> rtn = new ArrayList<Transcript>();

		try (Connection db = DriverManager.getConnection(dbURL); Statement st = db.createStatement()) {

			rtn = this.buildArrayListFromResultSet(st.executeQuery("select * from agile"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rtn;
	}

	private List<Transcript> buildArrayListFromResultSet(ResultSet set) {
		List<Transcript> rtn = new ArrayList<Transcript>();

		try {
			while (set.next()) {
				rtn.add(this.buildTranscript(set.getLong("id"), set.getString("firstName"), set.getString("lastName"),
						set.getString("email"), set.getInt("grade")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rtn;
	}

	private Transcript buildTranscript(long id, String firstName, String lastName, String email, int grade) {

		Transcript rtn = new Transcript(id, firstName, lastName, email, grade, grade > 68);

		return rtn;
	}

}
