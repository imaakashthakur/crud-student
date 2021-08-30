/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Aakash Thakur
 */

@Entity
@Getter
@Setter
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "Student.viewDeletedStudent", query = "SELECT s FROM Student s WHERE s.isActive = :isActive")
})
@JsonbPropertyOrder({"id", "firstName", "lastName", "address"})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    @NotNull
    private String firstName;
    
    private String lastName;
    
    private String address;
    
    private Character isActive;

    public Student() {
    }    
}
