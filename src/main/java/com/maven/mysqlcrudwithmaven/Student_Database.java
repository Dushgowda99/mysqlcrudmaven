package com.maven.mysqlcrudwithmaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student_Database {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Statement stmnt;
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdemo1","root","Dgcoorg@1998");
		System.out.println("Database connection successfully established");
		stmnt=(Statement)con.createStatement();
		ResultSet res=null;
		Scanner in=new Scanner(System.in);
		String choice="";
		System.out.println("Welcome to Student Database");
		
		do {
			System.out.println("1. Insert Data to Student Database");
			System.out.println("2. Update Data in Student Database");
			System.out.println("3. Search for a data in Student Database");
			System.out.println("4. Display Student Database");
			System.out.println("5. Delete Data from Student Database");
			System.out.println("6. Count the number of Students in the Database");
			System.out.println("7. Exit from Student Database");
			System.out.println("Enter your choice : ");
			choice=in.next();
			switch(choice) {
			
			case "1":
				
				System.out.println("Enter Student ID(*): ");
				int id=in.nextInt();
				System.out.println("Enter Student Name(*): ");
				String name=in.next();
				System.out.println("Enter Student Class(*): ");
				int Class=in.nextInt();
				System.out.println("Enter Student Father Name: ");
				String fname=in.next();
				System.out.println("Enter Student Mother Name: ");
				String mname=in.next();
				System.out.println("Enter Student Address(*): ");
				String address=in.next();
				System.out.println("Enter Student Birth Date[YYYY-MM-DD](*): ");
				String DOB=in.next();
				System.out.println("Enter Student Age(*): ");
				int age=in.nextInt();
				System.out.println("Enter Student Percentage: ");
				double percent=in.nextDouble();
				String query1="insert into student values("+id+",'"+name+"',"+Class+",'"+fname+"','"+mname+"','"+address+"','"+DOB+"',"+age+","+percent+")";
				stmnt.executeUpdate(query1);
				break;
				
			case "2":
				
				String us="";
				String str="",newstr="";
				System.out.println("Select all the categories for updation Based on Student ID: ");
				System.out.println("Enter Student ID: ");
				int Id=in.nextInt();
				do {
					System.out.println("a. Update Student's Name ");
					System.out.println("b. Update Student's Class ");
					System.out.println("c. Update Student's Father Name ");
					System.out.println("d. Update Student's Mother Name ");
					System.out.println("e. Update Student's Address ");
					System.out.println("f. Update Student's Date of Birth ");
					System.out.println("g. Update Student's Age ");
					System.out.println("h. Update Student's Percentage ");
					System.out.println("q. Exit from Updation");
					System.out.println("Enter your choice : ");
					us=in.next();
					switch(us) {
					case "a":str.concat("sname=?,");
						break;
					case "b":str.concat("sclass=?,");
						break;
					case "c":str.concat("sfname=?,");
						break;
					case "d":str.concat("smname=?,");
						break;
					case "e":str.concat("saddress=?,");
						break;
					case "f":str.concat("sbdate=?,");
						break;
					case "g":str.concat("sage=?,");
						break;
					case "h":str.concat("spercentage=?,");
						break;
					case "q":
						break;
						default:System.out.println("Invalid option");
						break;
					}
				}while(!us.toLowerCase().equals("q"));
				try {
				newstr=str.substring(0,str.length()-1);
				System.out.println(newstr);
				}
				catch(StringIndexOutOfBoundsException e) {
					System.out.println("You should make atleast one choice \n Now please run the programm again");
				}
				PreparedStatement ps = con.prepareStatement("update student set "+newstr+" where sid=?");
				
				int cc=1;
				if(newstr.contains("sname")) {
					String n="";
					System.out.println("Enter Student's updated Name :");
					n=in.next();
					ps.setString(cc,n);
					cc++;
				}
				
				else if(newstr.contains("sclass")) {
					int cclass=0;
					System.out.println("Enter Student's updated Class :");
					cclass=in.nextInt();
					ps.setInt(cc, cclass);
					cc++;
				}
				else if(newstr.contains("sfname")) {
					String n="";
					System.out.println("Enter Student's updated Father Name :");
					n=in.next();
					ps.setString(cc,n);
					cc++;
				}
				else if(newstr.contains("smname")) {
					String n="";
					System.out.println("Enter Student's updated Mother Name :");
					n=in.next();
					ps.setString(cc,n);
					cc++;
				}
				else if(newstr.contains("saddress")) {
					String n="";
					System.out.println("Enter Student's updated Address :");
					n=in.next();
					ps.setString(cc,n);
					cc++;
				}
				else if(newstr.contains("sbdate")) {
					String n="";
					System.out.println("Enter Student's updated Date of Birth :");
					n=in.next();
					ps.setString(cc,n);
					cc++;
				}
				else if(newstr.contains("sage")) {
					int cclass=0;
					System.out.println("Enter Student's updated Age :");
					cclass=in.nextInt();
					ps.setInt(cc, cclass);
					cc++;
				}
				else if(newstr.contains("spercentage")) {
					int cclass=0;
					System.out.println("Enter Student updated percentage :");
					cclass=in.nextInt();
					ps.setInt(cc, cclass);
					cc++;
				}
			
				ps.setInt(cc,Id);
				int i=ps.executeUpdate();
				System.out.println("Record updated "+i);
				
				break;
				
			case "3":
				
				String uss="";
				String strr="",newstrr="";
				System.out.println("Choose columns of Data you want to view ");
				do {
					System.out.println("a. Student's Name ");
					System.out.println("b. Student's Class ");
					System.out.println("c. Student's Father Name ");
					System.out.println("d. Student's Mother Name ");
					System.out.println("e. Student's Address ");
					System.out.println("f. Student's Date of Birth ");
					System.out.println("g. Student's Age ");
					System.out.println("h. Student's Percentage ");
					System.out.println("q. Exit from the screen");
					System.out.println("Enter your choice : ");
					uss=in.next();
					switch(uss) {
					case "a":strr.concat("sname,");
						break;
					case "b":strr.concat("sclass,");
						break;
					case "c":strr.concat("sfname,");
						break;
					case "d":strr.concat("smname,");
						break;
					case "e":strr.concat("saddress,");
						break;
					case "f":strr.concat("sbdate,");
						break;
					case "g":strr.concat("sage,");
						break;
					case "h":strr.concat("spercentage,");
						break;
					case "q":
						break;
						default:System.out.println("Invalid option");
							break;
					}
				}while(!uss.toLowerCase().equals("q"));
				try {
				newstrr=strr.substring(0,strr.length()-1);
				}
				catch(StringIndexOutOfBoundsException e) {
					System.out.println("You should make atleast one choice \n Now please run the programm again");
				}
				PreparedStatement ps1 = con.prepareStatement("select "+newstrr+" from student"); 
				res=ps1.executeQuery();
				while(res.next()) {
					if(newstrr.contains("sid")) {
						System.out.println(" Student ID : "+res.getInt("sid"));
					}
					else if(newstrr.contains("sname")) {
						System.out.println(" Student Name : "+res.getString("sname"));
					}
					else if(newstrr.contains("sclass")) {
						System.out.println(" Student Class : "+res.getInt("sclass"));
					}
					else if(newstrr.contains("sfname")) {
						System.out.println(" Student FatherName : "+res.getString("sfname"));
					}
					else if(newstrr.contains("smname")) {
						System.out.println(" Student MotherName : "+res.getString("smname"));
					}
					else if(newstrr.contains("saddress")) {
						System.out.println(" Student Address : "+res.getString("saddress"));
					}
					else if(newstrr.contains("sbdate")) {
						System.out.println(" Student Date of Birth : "+res.getString("sbdate"));
					}
					else if(newstrr.contains("sage")) {
						System.out.println(" Student Age : "+res.getInt("sage"));
					}
					else if(newstrr.contains("spercentage")) {
						System.out.println(" Student FatherName : "+res.getDouble("spercentage"));
					}
					System.out.println();
					
				}
				break;
				
			case "4":
				
				res=stmnt.executeQuery("select * from student");
				while(res.next()) {
					System.out.print(" Student ID : "+res.getInt("sid"));
					System.out.print(" Student Name : "+res.getString("sname"));
					System.out.print(" Student Class : "+res.getInt("sclass"));
					System.out.print(" Student Father Name : "+res.getString("sfname"));
					System.out.print(" Student Mother Name : "+res.getString("smname"));
					System.out.print(" Student Address : "+res.getString("saddress"));
					System.out.print(" Student DOB : "+res.getDate("sbdate"));
					System.out.print(" Student Age : "+res.getInt("sage"));
					System.out.print(" Student Percentage : "+res.getDouble("spercentage"));
					System.out.println();
				}
				res.close();
				break;
				
			case "5":
				
				System.out.println("Enter Student ID for Removal: ");
				int ds=in.nextInt();
				try {
				PreparedStatement ps2 = con.prepareStatement("delete from student where sid=?");
				ps2.setInt(1, ds);
				int j = ps2.executeUpdate();
				System.out.println("Record deleted :" +j);
				}
				catch(ArithmeticException e) {
					System.out.println("Student ID Doesn't match with the existing database!!");
				}
				break;
				
			
			case "7":
				
				System.exit(0);
				break;
			
			
			default:
					System.out.println("Invalid Choice");
					break;
			}	
			
		}while(Integer.parseInt(choice)!=7);

		in.close();
	}

}
