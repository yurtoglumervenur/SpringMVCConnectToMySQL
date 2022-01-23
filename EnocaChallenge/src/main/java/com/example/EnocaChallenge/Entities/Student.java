package com.example.EnocaChallenge.Entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Student")
@Data
public class Student implements Serializable {
    @Column(name = "student_no")
    @Id
    Integer studentNo;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    @OneToOne
    @JoinColumn(name = "department_no",nullable = false)
    Department department;

    public Integer getStudentNo() {
        return studentNo;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department){
        this.department=department;
    }
}
