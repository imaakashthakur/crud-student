/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao;

import com.mycompany.entity.Student;
import java.util.List;

/**
 *
 * @author Aakash Thakur
 */
public interface StudentDAO {
    List<Student> getAll();
    
    Student saveOrUpdate(Student student);
    
    void deleteById(int id);
    
    List<Student> getDeletedStudent();
    
    void rollBackDeletedStudent(int id);
}
