package com.san.j2ee_springboot_mvc_thymeleaf_mysql_crud.Implmentation;


import com.san.j2ee_springboot_mvc_thymeleaf_mysql_crud.Models.Employee;
import com.san.j2ee_springboot_mvc_thymeleaf_mysql_crud.Services.EmployeeService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeImpl implements EmployeeService {


    public EmployeeImpl() throws SQLException {
    }

    @Override
    public boolean addEmployee(Employee emp) throws ClassNotFoundException, SQLException {

        String dbUser="root";
        String dbPass="root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connString = "jdbc:mysql://localhost:3306/dbservlet?useSSL=false";
        Connection con = DriverManager.getConnection(connString, dbUser, dbPass);
        Statement stmt = con.createStatement();

        String name=emp.getName();
        String address=emp.getAddress();
        String email=emp.getEmail();

        String sql="insert into employee values (null,\"" +name+"\",\""+address+"\",\""+email+"\")";
        stmt.executeUpdate(sql);
        return true;
    }

    @Override
    public boolean editEmployee(Employee emp) throws ClassNotFoundException, SQLException {
        String dbUser="root";
        String dbPass="root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connString = "jdbc:mysql://localhost:3306/dbservlet?useSSL=false";
        Connection con = DriverManager.getConnection(connString, dbUser, dbPass);
        Statement stmt = con.createStatement();

        String name=emp.getName();
        String address=emp.getAddress();
        String email=emp.getEmail();

        String sql="update employee set name='"+name+"',address='"+address+"',email='"+email+"' where id="+ emp.getId()+"";
        //System.out.println(sql);
        stmt.executeUpdate(sql);
        return true;
    }

    @Override
    public ArrayList<Employee> listEmployee() throws SQLException, ClassNotFoundException {
        String dbUser="root";
        String dbPass="root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connString = "jdbc:mysql://localhost:3306/dbservlet";
        Connection con = DriverManager.getConnection(connString, dbUser, dbPass);
        Statement stmt = con.createStatement();

        ArrayList<Employee> employees = new ArrayList<>();
        String sql="select * from employee";
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next()){
            Employee emp=new Employee();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name")); //name
            emp.setAddress(rs.getString("address"));
            emp.setEmail(rs.getString("email"));
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(int id) throws ClassNotFoundException, SQLException {
        String dbUser="root";
        String dbPass="root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connString = "jdbc:mysql://localhost:3306/dbservlet?useSSL=false";
        Connection con = DriverManager.getConnection(connString, dbUser, dbPass);
        Statement stmt = con.createStatement();

        String sql="delete from employee  where id="+id;
        System.out.println(sql);
        stmt.executeUpdate(sql);
        return true;

    }

    public Employee getEmployeeById(int id) throws ClassNotFoundException, SQLException {
        String dbUser="root";
        String dbPass="root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connString = "jdbc:mysql://localhost:3306/dbservlet";
        Connection con = DriverManager.getConnection(connString, dbUser, dbPass);
        Statement stmt = con.createStatement();

        String sql="select * from employee where id="+id;
        ResultSet rs=stmt.executeQuery(sql);
        rs.next();
        Employee emp=new Employee(rs.getInt("id"),rs.getString("name"),rs.getString("address"),rs.getString("email"));
        return emp;
    }
}
