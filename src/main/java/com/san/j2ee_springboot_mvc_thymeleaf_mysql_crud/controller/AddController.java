package com.san.j2ee_springboot_mvc_thymeleaf_mysql_crud.controller;

import com.san.j2ee_springboot_mvc_thymeleaf_mysql_crud.Implmentation.EmployeeImpl;
import com.san.j2ee_springboot_mvc_thymeleaf_mysql_crud.Models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

//all the apps folders must be in java->default package , here
//com.san.j2ee_Springboot_mvc_jsp_crud

@Controller
@RequestMapping("/")
public class AddController {

    @PostMapping("add")
    public String doAdd(@RequestParam("name") String name,@RequestParam("address") String address,
                        @RequestParam("email") String email){
        System.out.println("Adding student..");

        Employee newEmployee=new Employee(0,name,address,email);

        try {
            new EmployeeImpl().addEmployee(newEmployee);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Index...");
        return "redirect:/";
    }

    @GetMapping("add")
    public String test(){
        System.out.println("Add Controller called");
        return "frmAdd";
    }
}
