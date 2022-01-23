package com.example.EnocaChallenge.Services;

import com.example.EnocaChallenge.Entities.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> findAll();
    ResponseEntity<Optional<Student>> findById(Integer studentNo);
    ResponseEntity<String> save(Student newStudent);
    ResponseEntity<String> delete(Integer studentNo);
    ResponseEntity<String> update(Integer studentNo, Student student);

}
