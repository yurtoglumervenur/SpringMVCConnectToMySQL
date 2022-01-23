package com.example.EnocaChallenge.Controllers;

import com.example.EnocaChallenge.Entities.Student;
import com.example.EnocaChallenge.Services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.findAll();
    }

    @GetMapping("/{studentNo}")
    public ResponseEntity<Optional<Student>> selectStudent(@PathVariable Integer studentNo){
        return studentService.findById(studentNo);
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student newStudent){
        return studentService.save(newStudent);
    }

    @PutMapping("/{studentNo}")
    public ResponseEntity<String> updateStudent(@PathVariable("studentNo") Integer studentNo, @RequestBody Student student){
        return studentService.update(studentNo, student);
    }

    @DeleteMapping("/{studentNo}")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentNo") Integer studentNo){
        return studentService.delete(studentNo);
    }
}
