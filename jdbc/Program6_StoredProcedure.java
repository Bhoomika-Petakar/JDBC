package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

public class Program6_StoredProcedure {
	public static Connection connection;
	public static Statement statement;
	private static PreparedStatement statement2;
	public final static Scanner scan=new Scanner(System.in);
	public static CallableStatement call;

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Bhoomi@007";
		
		try {
			connection=DriverManager.getConnection(url,username,password);
			call=connection.prepareCall("{ call count_department(?,?)}");
			
			call.setString(1, scan.next());
			call.registerOutParameter(2,Types.INTEGER);
			
			call.execute();
			int count=call.getInt(2);
			System.out.println(count);
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
