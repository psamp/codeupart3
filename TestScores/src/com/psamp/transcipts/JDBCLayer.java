package com.psamp.transcipts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCLayer {
	private String dbURL = "jdbc:mysql://localhost/transcripts?user=root&password=rooty&useSSL=true";
	private String tableName;

	public JDBCLayer(String name) {
		this.tableName = name;
	}

	public int postNewTranscript(String firstName, String lastName, String email, String date, int grade) {

		int rtn = -1;

		try (Connection connection = DriverManager.getConnection(this.getDbURL());
				Statement statement = connection.createStatement()) {

			String sql = "insert into " + this.getTableName() + "(firstName, lastName, email, taken, grade) values ( '"
					+ firstName + "', '" + lastName + "', '" + email + "', '" + date + "', " + grade + ")";

			rtn = statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rtn;
	}

	public List<Transcript> getAllFromCurrentTable() {

		List<Transcript> rtn = null;

		try (Connection connection = DriverManager.getConnection(this.getDbURL());
				Statement statement = connection.createStatement()) {

			rtn = this.buildArrayListOfTranscriptsFromResultSet(
					statement.executeQuery("select * from " + this.getTableName()));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rtn;
	}

	List<Transcript> searchTableByID(int id) {
		List<Transcript> rtn = null;

		try (Connection connection = DriverManager.getConnection(this.getDbURL());
				Statement statement = connection.createStatement()) {

			rtn = this.buildArrayListOfTranscriptsFromResultSet(
					statement.executeQuery("select * from " + this.getTableName() + " where id = " + id));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rtn;
	}

	private List<Transcript> buildArrayListOfTranscriptsFromResultSet(ResultSet set) {
		List<Transcript> rtn = new ArrayList<Transcript>();

		try {
			while (set.next()) {
				rtn.add(this.buildNewTranscriptInstance(set.getLong("id"), set.getString("firstName"),
						set.getString("lastName"), set.getString("email"), set.getString("taken"),
						set.getInt("grade")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rtn;
	}

	private Transcript buildNewTranscriptInstance(long id, String firstName, String lastName, String email,
			String dateTaken, int grade) {

		Transcript rtn = new Transcript(id, firstName, lastName, email, dateTaken, grade);

		return rtn;
	}

	String getTableName() {
		return tableName;
	}

	String getDbURL() {
		return dbURL;
	}

}
