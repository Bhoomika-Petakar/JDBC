package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program5 {
	public static Connection connection;
	public static Statement statement;
	private static PreparedStatement statement2;
	public final static Scanner scan=new Scanner(System.in);
	public static String choice;

public static void main(String[] args) {
	String url="jdbc:mysql://localhost:3306/jdbcclasses";
	String username="root";
	String password="Bhoomi@007";
	
	String sql1="UPDATE `employees` SET `salary`=`salary`+? WHERE `department`=`IT`";
	
	try {
		do{
		Class.forName("com.mysql.cj.jdbc.Driver");
	connection=DriverManager.getConnection(url,username,password);
	Program2.display(null,statement,connection);
	statement2.setInt(1, scan.nextInt());
	statement2.setString(1, scan.next());
	statement2.addBatch();
	
	
	System.out.println("Do you want to add another user??????(yes/no)");
	choice=scan.next();
		}
while(choice.equalsIgnoreCase("yes"));
statement.executeBatch();
Program2.display(null,statement,connection);

}catch (ClassNotFoundException c) {
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
