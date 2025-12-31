package com.employee;
import java.sql.*;

public class employee {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/fsademployee";
		String usr="root";
		String pwd="root";
		try {
			Connection con=DriverManager.getConnection(url, usr, pwd);
			System.out.println("Connection established");
			String createDept="create table if not exists dept1 ("+ "dept_id INT primary key,"
					+ " dept_name varchar(50))";
			Statement st=con.createStatement();
			st.executeUpdate(createDept);
			System.out.println("Department Table Created");
			String createEmp="create table if not exists Employee ("+ "emp_id int primary key,"
					+ " emp_name varchar(50)," + "salary DOUBLE,"+" dept_id INT,"+"FOREIGN KEY (dept_id) REFERENCES dept1(dept_id))";
			st.executeUpdate(createEmp);
			System.out.println("Employee Table Created");
			st.executeUpdate("INSERT INTO dept1 VALUES (2, 'CSE')");
			st.executeUpdate("INSERT INTO dept1 VALUES (3, 'ECE')");
			System.out.println("Dept values inserted");
			st.executeUpdate("INSERT INTO Employee VALUES (102,'Bob',60000,2)");
			st.executeUpdate("INSERT INTO Employee VALUES (103,'Charlie',70000,3)");
			System.out.println("Employee values inserted");
			con.close();
			System.out.println("Connection closed.");
		}
		catch(Exception e)
		{
			
		}
	}

}