package com.jdbcCRUD;
import java.sql.*;
import java.util.Scanner;
public class jdbccrud {
    static String url="jdbc:mysql://localhost:3306/fsadcrud";
    static String user="root";
    static String password="root";
    public static void main(String[] args){
        createTables();
        Scanner sc=new Scanner(System.in);
        int choice;
        do{
            System.out.println("\n1.Insert Department");
            System.out.println("2.Insert Employee");
            System.out.println("3.View Employee");
            System.out.println("4.Update Employee Salary");
            System.out.println("5.Delete Employee");
            System.out.println("6.Exit");
            choice=sc.nextInt();
            switch(choice){
                case 1:insertDept();
                    break;
                case 2:insertEmployee();
                    break;
                case 3:viewEmployees();
                    break;
                case 4:updateEmployee();
                    break;
                case 5:deleteEmployee();
                    break;
                case 6:System.out.println("Exiting...");
                    break;
                default:System.out.println("Invalid choice");
            }
        }while(choice!=6);
    }
    static void createTables(){
        try(Connection con=DriverManager.getConnection(url,user,password);
            Statement st=con.createStatement()){
            String deptTable="CREATE TABLE IF NOT EXISTS dept(dept_id INT PRIMARY KEY,dept_name VARCHAR(50))";
            String empTable="CREATE TABLE IF NOT EXISTS employee(emp_id INT PRIMARY KEY,emp_name VARCHAR(50),salary DOUBLE,dept_id INT,FOREIGN KEY(dept_id) REFERENCES dept(dept_id))";
            st.execute(deptTable);
            st.execute(empTable);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    static void insertDept(){
        try(Connection con=DriverManager.getConnection(url,user,password)){
            Scanner sc=new Scanner(System.in);
            PreparedStatement ps=con.prepareStatement("INSERT INTO dept VALUES(?,?)");

            ps.setInt(1,sc.nextInt());
            ps.setString(2,sc.next());
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    static void insertEmployee(){
        try(Connection con=DriverManager.getConnection(url,user,password)){
            Scanner sc=new Scanner(System.in);
            PreparedStatement ps=con.prepareStatement("INSERT INTO employee VALUES(?,?,?,?)");

            ps.setInt(1,sc.nextInt());
            ps.setString(2,sc.next());
            ps.setDouble(3,sc.nextDouble());
            ps.setInt(4,sc.nextInt());
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    static void viewEmployees(){
        try(Connection con=DriverManager.getConnection(url,user,password)){
            String sql="SELECT e.emp_id,e.emp_name,e.salary,d.dept_name FROM employee e JOIN dept d ON e.dept_id=d.dept_id";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    static void updateEmployee(){
        try(Connection con=DriverManager.getConnection(url,user,password)){
            Scanner sc=new Scanner(System.in);
            PreparedStatement ps=con.prepareStatement("UPDATE employee SET salary=? WHERE emp_id=?");
            ps.setDouble(1,sc.nextDouble());
            ps.setInt(2,sc.nextInt());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    static void deleteEmployee(){
        try(Connection con=DriverManager.getConnection(url,user,password)){
            Scanner sc=new Scanner(System.in);
            PreparedStatement ps=con.prepareStatement("DELETE FROM employee WHERE emp_id=?");
            ps.setInt(1,sc.nextInt());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}