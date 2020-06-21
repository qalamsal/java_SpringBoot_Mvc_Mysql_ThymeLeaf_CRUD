package com.san.j2ee_springboot_mvc_thymeleaf_mysql_crud.controller;

import com.san.j2ee_springboot_mvc_thymeleaf_mysql_crud.Implmentation.EmployeeImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

//all the apps folders must be in java->default package , here
//com.san.j2ee_Springboot_mvc_jsp_crud

@Controller
@RequestMapping("/")
public class DeleteController {

    @GetMapping("delete")
    public String test(@RequestParam("id") int id){
        //System.out.println("Add Controller called");
        try {
            new EmployeeImpl().deleteEmployee(id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
