package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Program2 {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbcclasses";
		String username="root";
		String password="Bhoomi@007";
			Connection myCon=null;
			Statement statement=null;
			ResultSet res=null;
			try {
				myCon = DriverManager.getConnection(url,username,password);
			    display(res,statement,myCon);
			     } 
			catch (SQLException e) {
				e.printStackTrace();
			}			
			finally {
				try {
					if(res!=null) {
					res.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if(statement!=null) {
					statement.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if(myCon!=null) {
					myCon.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
	}
	
		
	
	 static void display(ResultSet res,Statement statement,Connection myCon) throws SQLException 
		{
			    statement=myCon.createStatement();
				String sql="SELECT * from employees";
				res=statement.executeQuery(sql);
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
	}
