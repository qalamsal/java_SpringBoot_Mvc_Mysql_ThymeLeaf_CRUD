package com.san.j2ee_springboot_mvc_thymeleaf_mysql_crud.Services;


import com.san.j2ee_springboot_mvc_thymeleaf_mysql_crud.Models.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {

    boolean addEmployee(Employee emp) throws ClassNotFoundException, SQLException;
    boolean editEmployee(Employee emp) throws ClassNotFoundException, SQLException;
    List<Employee> listEmployee() throws SQLException, ClassNotFoundException;
    boolean deleteEmployee(int id) throws ClassNotFoundException, SQLException;
}
