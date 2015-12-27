package com.psamp.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class JDBCTEst {
	public static void main(String[] args) {

		ResultSet response = null;

		try (Connection db = DriverManager
				.getConnection("jdbc:mysql://localhost/transcripts?" + "user=root&password=rooty&useSSL=true");
				Statement st = db.createStatement()) {

			response = st.executeQuery("select * from agile");

			while (response.next()) {
				System.out.println(response.getString("firstName"));
				System.out.println(response.getString("email"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
