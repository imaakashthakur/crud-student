/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.company.service.StudentService;
import com.mycompany.entity.Student;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
//import javax.annotation.PostConstruct;
//import javax.faces.context.FacesContext;
//import javax.enterprise.context.SessionScoped;


/**
 *
 * @author Aakash Thakur
 */
@Named(value = "studentController")
//@SessionScoped -- Sabrin Di's remarks to stop storing information in the text boxes
@RequestScoped
public class StudentController implements Serializable {

    @EJB
    private StudentService studentServiceImpl;

    private Student student = new Student();

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentController() {
    }

    public List<Student> findAll() {
        return this.studentServiceImpl.getAll();
    }

    public String add() {
        this.studentServiceImpl.save(this.student);
        return "index";
    }

    public String delete() {
        this.studentServiceImpl.delteById(this.student.getId());
        return "index";
    }

    public String delete(Student student) {
        this.studentServiceImpl.delteById(student.getId());
        return "index";
    }

    public String update(Student student) {
        this.student = student;
        return "updateStudent";
    }

    public String update() {
        this.studentServiceImpl.update(this.student);
        return "index";
    }

    public List<Student> viewDeletedStudent() {
        return this.studentServiceImpl.getDeletedStudent();
    }

    public String rollBack() {
        this.studentServiceImpl.rollBackDeletedStudent(this.student.getId());
        return "index";
    }

    public String rollBack(Student student) {
        this.studentServiceImpl.rollBackDeletedStudent(student.getId());
        return "index";
    }
}
