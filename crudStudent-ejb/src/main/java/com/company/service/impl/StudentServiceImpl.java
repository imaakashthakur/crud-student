/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.dao.StudentDAO;
import com.company.service.StudentService;
import com.mycompany.entity.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Aakash Thakur
 */

@Stateless
public class StudentServiceImpl implements StudentService{

    @Inject
    private StudentDAO studentDAO;
    
    @Override
    public List<Student> getAll() {
        return studentDAO.getAll();
    }

    @Override
    public Student save(Student student) {
        Student savedStudent = studentDAO.saveOrUpdate(student);
        return studentDAO.saveOrUpdate(savedStudent);
    }

    @Override
    public Student update(Student student) {
        return studentDAO.saveOrUpdate(student);
    }

    @Override
    public void delteById(int id) {
        studentDAO.deleteById(id);
    }

    @Override
    public List<Student> getDeletedStudent() {
        return studentDAO.getDeletedStudent();
    }

    @Override
    public void rollBackDeletedStudent(int id) {
        studentDAO.rollBackDeletedStudent(id);
    }
    
}
