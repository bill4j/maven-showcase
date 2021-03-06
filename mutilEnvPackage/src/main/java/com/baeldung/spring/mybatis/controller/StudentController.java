package com.baeldung.spring.mybatis.controller;

import com.baeldung.spring.mybatis.model.Student;
import com.baeldung.spring.mybatis.model.StudentLogin;
import com.baeldung.spring.mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@Validated @ModelAttribute("student") Student student, BindingResult result, ModelMap model) {
        Student existStudent = studentService.getStudentByUserName(student.getUserName());
        if (existStudent != null) {
            model.addAttribute("message", "User Name exists. Try another user name");
            return "signup";
        } else {
            student.setId(2l);
            student.setDateOfBirth(new Date());
            studentService.insertStudent(student);
            model.addAttribute("message", "Saved student details");
            return "redirect:login.html";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        StudentLogin studentLogin = new StudentLogin();
        model.addAttribute("studentLogin", studentLogin);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("studentLogin") StudentLogin studentLogin, BindingResult result, ModelMap model) {
        Student existStudent = studentService.getStudentByLogin(studentLogin.getUserName(), studentLogin.getPassword());
        if (existStudent != null) {
            return "success";
        } else {
            return "failure";
        }
    }
}