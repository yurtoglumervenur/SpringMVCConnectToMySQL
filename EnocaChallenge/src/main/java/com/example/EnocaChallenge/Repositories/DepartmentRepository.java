package com.example.EnocaChallenge.Repositories;

import com.example.EnocaChallenge.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
