package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Program4 {

	public static Connection connection;
	public static Statement statement;

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbcclasses";
		String username = "root";
		String password = "Bhoomi@007";
		String sql1 = "INSERT into `employees` (`id`,`name`,`email` , `department`,`salary`)values(4,'bhitu','bhitu@gmail.com','HR',120000)";
		String sql2 = "INSERT into `employees` (`id`,`name`,`email` , `department`,`salary`)values(5,'kory','kory@gmail.com','IT',500000)";
		String sql3 = "INSERT into `employees` (`id`,`name`,`email` , `department`,`salary`)values(6,'lizz','lizz@gmail.com','HR',70000)";
		String sql4 = "INSERT into `employees` (`id`,`name`,`email` , `department`,`salary`)values(7,'ruby','ruby@gmail.com','Testing',110000)";
		String sql5 = "INSERT into `employees` (`id`,`name`,`email` , `department`,`salary`)values(8,'sherin','sherin@gmail.com','Testing',990000)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
			statement.addBatch(sql1);
			statement.addBatch(sql2);
			statement.addBatch(sql3);
			statement.addBatch(sql4);
			statement.addBatch(sql5);

			int[] ar = statement.executeBatch();
			for (int i = 0; i < ar.length; i++) {
				System.out.println(ar[i] + " ");
			}
			System.out.println();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
