package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

public class Program3 {
	public static Connection connection;
	public static Statement statement;
	
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Bhoomi@007";
String sql="DELETE from `employees` WHERE `id`=1";		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(url,username,password);
		statement=connection.createStatement();
		int i=statement.executeUpdate(sql);
		System.out.println(i);
		}
		catch (ClassNotFoundException c) {
			c.printStackTrace();
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				if(statement!=null) {
					statement.close();
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
				}
			
			try {
				if(connection!=null) {
					connection.close();
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
				}
			
			
			
			}
		
		
		
	}


}
