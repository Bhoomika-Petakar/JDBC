package com.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program9_BLOB {
	public static Connection connection;
	public static Statement statement;
	private static PreparedStatement statement2;
	public final static Scanner scan=new Scanner(System.in);
	public static FileInputStream fis;

public static void main(String[] args) throws FileNotFoundException {
	String url="jdbc:mysql://localhost:3306/jdbcclasses";
	String username="root";
	String password="Bhoomi@007";
	
	String sql1="UPDATE `employees` SET `dp`=? WHERE `id`=?";
	
	try {
		
	fis=new FileInputStream("C:\\Users\\bhoom\\eclipse-workspace2\\JDBCclasses\\src\\album\\download.jpeg");
	connection=DriverManager.getConnection(url,username,password);
	statement2=connection.prepareStatement(sql1);
	statement2.setBinaryStream(2,fis);
	statement2.setInt(1, scan.nextInt());
	int i=statement2.executeUpdate();
	System.out.println(i);
	
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
