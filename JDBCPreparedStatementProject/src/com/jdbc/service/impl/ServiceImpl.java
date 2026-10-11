package com.jdbc.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.jdbc.service.I.Requirement;

public class ServiceImpl implements Requirement {

	
	Scanner sc = new Scanner(System.in);
	
	
	@Override
	public void createTable() {

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/day2_preparedstatement","root","root");
			
			String query = "create table student(rollno int primary key , name varchar(45) not null , marks float , email varchar(45) Unique )";
			
			PreparedStatement ps =con.prepareStatement(query);
			
			System.out.println("Table created successfully\n");
			 
			ps.execute();
			
			con.close();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void insertData() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/day2_preparedstatement","root","root");
		
			String query = "insert into student values(?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			
				System.out.println("Enter how many student do you want to add:\n ");
				int n = sc.nextInt();
				
				for(int i = 1; i<=n; i++) {
					
					System.out.println("-------------Enter Student "+i+" Details-------------\n");
					System.out.println("Enter Roll Number");
					ps.setInt(1, sc.nextInt());
					
					System.out.println("Enter Name");
					ps.setString(2, sc.next());
					
					System.out.println("Enter Marks");
					ps.setFloat(3, sc.nextFloat());
					
					System.out.println("Enter Email");
					ps.setString(4, sc.next());
					
			
					ps.execute();
				}
				
					System.out.println();
					System.out.println("Data inserted successfully\n ");
			
					con.close();

		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateData() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/day2_preparedstatement","root","root");
			
			String query = "Update student set name = ? where rollno = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			System.out.println("Enter Name");
			ps.setString(1, sc.next());
			
			System.out.println("Enter Roll Number");
			ps.setInt(2, sc.nextInt());
			
			ps.execute();
			
			System.out.println("Data updated successfully\n ");
			con.close();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	
	}

	@Override
	public void getAllData() {
	
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/day2_preparedstatement","root","root");
			
			String query = "select * from student";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet set = ps.executeQuery();
			
			System.out.println("---------------Student Details---------------\n");
			while(set.next()) {
				
				System.out.println("Student Roll Number: "+set.getInt(1));
				System.out.println("Student Name is    : "+set.getString(2));
				System.out.println("Student Marks is   : "+set.getFloat(3));
				System.out.println("Student Email Id is: "+set.getString(4));
				System.out.println("\n-----------------------------------\n");
			}
			
				con.close();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteData() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/day2_preparedstatement","root","root");
			
			String query = "delete from student where rollno = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			System.out.println("Enter RollNumber To Delete.");
			ps.setInt(1, sc.nextInt());
			
			ps.execute();
			
			System.out.println("Data deleted successfully \n");
			
			con.close();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteTable() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/day2_preparedstatement","root","root");
			
			String query = "drop table student";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.execute();
			
			System.out.println("Table deleted successfully !\n");
			con.close();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	

	

}
