package com.maven.mysqlcrudwithmaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class checkConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Statement stmnt;
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdemo","root","Dgcoorg@1998");
		System.out.println("Database connection successfully established");
		stmnt=(Statement)con.createStatement();
		ResultSet res=null;
		
		
		/*
		 * ------------select required items using prepared statement-----------
		 */
		/*
		 PreparedStatement ps1 = con.prepareStatement("select * from student");
		 
		res=ps1.executeQuery();
		
		while(res.next()) {
			int sid=res.getInt(1);
			String sn=res.getString(2);
			System.out.print("Student ID : "+res.getInt("sid"));
			System.out.print(" Student Name : "+res.getString("sname"));
			System.out.print(" Student City : "+res.getString("scity"));
			System.out.print(" Student DOB : "+res.getDate("sbdate"));
			
			System.out.print(" Student Percentage : "+res.getDouble("spercentage"));
			System.out.print(" Student Age : "+res.getInt("sage"));
			
			System.out.println("student id :"+sid);
			System.out.print(" Student Name : "+sn);
			System.out.println();
			
		}
	*/
		
		
		//--------------update with prepared statement--------
		PreparedStatement ps = con.prepareStatement("update student set sname=?,sage=? where sid=?");
		ps.setString(1,"rajesh");
		ps.setInt(2, 31);
		ps.setInt(3, 11);
		int i = ps.executeUpdate();
		System.out.println("Record updated :" +i);
		
		
		/*
		 *----------delete with prepared statement-----------
		PreparedStatement ps = con.prepareStatement("delete from student where sid=?");
		ps.setInt(1, 12);
		int i = ps.executeUpdate();
		System.out.println("Record deleted :" +i);
		*/
		
		/*-----insert with prepared statement--------
		PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?)");
		ps.setInt(1, 12);
		ps.setString(2, "rajesh");
		ps.setString(3, "Kochi");
		ps.setString(4,"2023-01-01");
		ps.setDouble(5,98.02);
		ps.setInt(6, 31);
		int i = ps.executeUpdate();
		System.out.println("Record inserted:" +i);
		*/
		
		/*
		 * ------------retrieval-----------
		 * res=stmnt.executeQuery("select * from student");
		while(res.next()) {
			System.out.print("Student ID : "+res.getInt("sid"));
			System.out.print(" Student Name : "+res.getString("sname"));
			System.out.print(" Student City : "+res.getString("scity"));
			System.out.print(" Student DOB : "+res.getDate("sbdate"));
			System.out.print(" Student Percentage : "+res.getDouble("spercentage"));
			System.out.print(" Student Age : "+res.getInt("sage"));
			System.out.println();
		}
		 */
		
		/*
		 * -----insert-----
		String query1="INSERT INTO student values(9,'smriti','pune','2023-06-25',97.47,28)";
		stmnt.executeUpdate(query1);
		System.out.println("Record is inserted in the table successfully");
		*/
		
		
		/*
		 *--------delete-----
		  String query2="delete from student where sname='ramesh'";
		  stmnt.executeUpdate(query2);
		 */
		
		Scanner in=new Scanner(System.in);
		
		
		/*---------update----------
		String str=in.next();
		String query3="update student set sname='"+str+"' where sid=5";
		stmnt.executeUpdate(query3);
		System.out.println("Record is updated in the table successfully");
		*/
		
		
		/*---------insert with user entered data----------
		System.out.println("Enter Student ID: ");
		int id=in.nextInt();
		System.out.println("Enter Student Name: ");
		String name=in.next();
		System.out.println("Enter Student City: ");
		String city=in.next();
		System.out.println("Enter Student Birth Date: ");
		int date=in.nextInt();
		System.out.println("Enter Birth month: ");
		int month=in.nextInt();
		System.out.println("Enter Birth year: ");
		int year=in.nextInt();
		System.out.println("Enter percentage: ");
		double percent=in.nextDouble();
		System.out.println("Enter age: ");
		int age=in.nextInt();
		
		String query4="insert into student values("+id+",'"+name+"','"+city+"','"+year+"-"+month+"-"+date+"',"+percent+","+age+")";
		stmnt.executeUpdate(query4);
		*/
		
	
		
		
		
		con.close();
		in.close();
	}

}
