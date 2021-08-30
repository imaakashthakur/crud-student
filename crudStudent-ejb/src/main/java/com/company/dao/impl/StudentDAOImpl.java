/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.StudentDAO;
import com.mycompany.entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Aakash Thakur
 */

@Stateless
public class StudentDAOImpl implements StudentDAO{

    @PersistenceContext(unitName = "student")
    EntityManager em;
    
    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        
        try{
            Query query = em.createNamedQuery("Student.findAll");
            query.setParameter("isActive", 'Y');
            students = query.getResultList();
        }
        catch(Exception ex){
            System.out.println("Exception Found: " + ex);
        }
        return students;
    }

    @Override
    public Student saveOrUpdate(Student student) {
        student.setIsActive('Y');
        if(student.getId() == null || student.getId() == 0){
            em.persist(student);
        } else{
            em.merge(student);
        }
        return student;
    }

    @Override
    public void deleteById(int id) {
        Student student = this.em.find(Student.class, id);
        
        if(student != null){
            student.setIsActive('N');
            em.merge(student);
        }
    }

    @Override
    public List<Student> getDeletedStudent() {
        List<Student> students = new ArrayList<>();
        
        try{
            Query query = em.createNamedQuery("Student.findAll");
            query.setParameter("isActive", 'N');
            students = query.getResultList();
        }
        catch(Exception ex){
            System.out.println("Exception Found: " + ex);
        }
        return students;
    }

    @Override
    public void rollBackDeletedStudent(int id) {
        Student student = this.em.find(Student.class, id);
        
        if(student != null){
            student.setIsActive('Y');
            em.merge(student);
        }
    }
    
}
