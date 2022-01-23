package com.example.EnocaChallenge.Entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Department")
@Data
public class Department implements Serializable {
    @Id
    @Column(name = "department_no")
    private Integer departmentNo;

    @Column(name = "department_name")
    private String departmentName;

    public Department() {
    }

    public Integer getDepartmentNo() {
        return departmentNo;
    }
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentNo(Integer departmentNo) {
        this.departmentNo = departmentNo;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
