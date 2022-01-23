package com.example.EnocaChallenge.Services;

import com.example.EnocaChallenge.Entities.Department;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> findAll();
    ResponseEntity<Optional<Department>> findById(Integer departmentNo);
    ResponseEntity<String> save( Department newDepartment);
    ResponseEntity<String> update(Integer departmentNo, Department newDepartment);
    ResponseEntity<String> delete(Integer departmentNo);
}
