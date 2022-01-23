package com.example.EnocaChallenge.Controllers;

import com.example.EnocaChallenge.Entities.Department;
import com.example.EnocaChallenge.Services.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartment(){
        return departmentService.findAll();
    }

    @GetMapping("/{departmentNo}")
    public ResponseEntity<Optional<Department>> selectDepartment(@PathVariable Integer departmentNo){
        return departmentService.findById(departmentNo);
    }

    @PostMapping
    public ResponseEntity<String> addDepartment(@RequestBody Department newDepartment){
        return departmentService.save(newDepartment);
    }

    @PutMapping("/{departmentNo}")
    public ResponseEntity<String> updateDepartment(@PathVariable("departmentNo") Integer departmentNo, @RequestBody Department newDepartment){
        return departmentService.update(departmentNo,newDepartment);
    }

    @DeleteMapping("/{departmentNo}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("departmentNo") Integer departmentNo){
        return departmentService.delete(departmentNo);
    }
}
