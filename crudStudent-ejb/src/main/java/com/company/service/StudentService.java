/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service;

import com.mycompany.entity.Student;
import java.util.List;

/**
 *
 * @author Aakash Thakur
 */
public interface StudentService {
    List<Student> getAll();
    
    Student save (Student student);
    
    Student update (Student student);
    
    void delteById(int id);
    
    List<Student> getDeletedStudent();
    
    void rollBackDeletedStudent(int id);
    
}
