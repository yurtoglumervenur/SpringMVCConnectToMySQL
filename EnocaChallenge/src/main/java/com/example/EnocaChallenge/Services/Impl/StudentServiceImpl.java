package com.example.EnocaChallenge.Services.Impl;

import com.example.EnocaChallenge.Entities.Student;
import com.example.EnocaChallenge.Repositories.StudentRepository;
import com.example.EnocaChallenge.Services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public ResponseEntity<Optional<Student>> findById(Integer studentNo) {
        Optional<Student> findStudent = studentRepository.findById(studentNo);
        if(findStudent.isPresent()){
            return ResponseEntity.ok(findStudent);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<String> save(Student newStudent) {
        Optional<Student> student = studentRepository.findById(newStudent.getStudentNo());
        if(student.isPresent()){
            return new ResponseEntity<>("Kayıtlı öğrenci var.",HttpStatus.BAD_REQUEST);
        }
        studentRepository.save(newStudent);
        return new ResponseEntity<>("Öğrenci eklendi.",HttpStatus.OK);
    }
    @Override
    public ResponseEntity<String> delete(Integer studentNo){
        Optional<Student> student = studentRepository.findById(studentNo);
        if(student.isPresent()){
            studentRepository.deleteById(studentNo);
            return new ResponseEntity<>("Öğrenci silindi",HttpStatus.OK);
        }else{
        return new ResponseEntity<>("Öğrenci bulunamadı",HttpStatus.BAD_REQUEST);
    }}
    @Override
    public ResponseEntity<String> update(Integer studentNo, Student student) {
        Optional<Student> updateStudent = studentRepository.findById(student.getStudentNo());
        if(updateStudent.isPresent()){
            studentRepository.findById(studentNo).ifPresent(newStudent->{
                newStudent.setName(student.getName());
                newStudent.setSurname(student.getSurname());
                newStudent.setDepartment(student.getDepartment());
                studentRepository.save(newStudent);
            });
            return new ResponseEntity<>("Öğrenci güncellendi",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Öğrenci güncellenemedi.",HttpStatus.BAD_REQUEST);
    }}
}
