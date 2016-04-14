package com.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	// tova sa nastroikite na predishniq ni proekt ot mysql oshte tursq kak da
	// si izkopam nastroikite ot nastoqshtiq nai-veche url-a
	public static final String DB_HOST = "localhost";
	public static final String DB_NAME = "earlyedition";
	public static final String DB_PORT = "3306";
	public static final String DB_PASS = "Teresa1";
	public static final String DB_USER = "root";
	public static final String DB = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
//	private static final String url = "jdbc:mysql://127.0.0.1:3306/ninegag?useSSL=false";
//	private static final String user = "boris";
//	private static final String password = "Istinataboli1@";

	private static DBConnection instance = null;

	private Connection con;

	private DBConnection() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DB, DB_USER, DB_PASS);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DBConnection getInstance() {
		if (instance == null) {
			synchronized (DBConnection.class) {
				if (instance == null) {
					instance = new DBConnection();
				}
			}
		}
		return instance;
	}

	public Connection getCon() {
		return con;
	}

}
