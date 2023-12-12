package com.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class program1 {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Bhoomi@007";
		
		try{
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("Connection Started......");
		

	}catch(SQLException e) {
		e.printStackTrace();
	}
		
	}
	

}
