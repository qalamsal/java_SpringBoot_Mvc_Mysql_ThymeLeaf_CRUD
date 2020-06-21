package com.san.j2ee_springboot_mvc_thymeleaf_mysql_crud.controller;

import com.san.j2ee_springboot_mvc_thymeleaf_mysql_crud.Implmentation.EmployeeImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

//all the apps folders must be in java->default package , here
//com.san.j2ee_Springboot_mvc_jsp_crud

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping("")
    public String showEmployees(Model mv) throws SQLException, ClassNotFoundException {
        System.out.println("Home Page Controller");
        mv.addAttribute("employees", new EmployeeImpl().listEmployee());
        return "index";
    }
}
