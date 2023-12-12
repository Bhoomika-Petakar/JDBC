package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program8_SP_retrv_salary {
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
			call=connection.prepareCall("{ call display_emplyeelessersalary(?)}");
			System.out.println("ENTER SALARY: ");
			call.setInt(1, scan.nextInt());
			//no output parameter
			
			call.execute();
			ResultSet res=call.getResultSet();
			System.out.println("---------------------------------------------------------------");
		    while(res.next()) {
		    	
			int id=res.getInt("id");
			String name=res.getString("name");
			int salary=res.getInt("salary");
			String department = res.getString("department");
			String email =res.getString("email");
			System.out.printf("|%-3d | %-12s | %-18s | %-8s | %-7d |\n",id,name,email,department,salary);
		   }
			System.out.println("---------------------------------------------------------------");
			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
	}


}
