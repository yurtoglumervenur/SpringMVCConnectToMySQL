package com.example.EnocaChallenge.Repositories;

import com.example.EnocaChallenge.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Integer> {

}
