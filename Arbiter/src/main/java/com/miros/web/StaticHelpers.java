package com.miros.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class StaticHelpers {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");

	public Timestamp getTimestamp() {
		System.out.println("Timestamp created");
		return new Timestamp(System.currentTimeMillis());
	}

	public Connection getCon() throws Exception {
		String url = "jdbc:mysql://localhost:3306/ardeos_corporation";
		String name = "root";
		String pass = "246135";

		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, name, pass);
	}
}
