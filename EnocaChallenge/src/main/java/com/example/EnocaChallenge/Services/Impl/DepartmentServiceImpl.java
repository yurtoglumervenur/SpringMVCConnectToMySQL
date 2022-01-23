package com.example.EnocaChallenge.Services.Impl;

import com.example.EnocaChallenge.Entities.Department;
import com.example.EnocaChallenge.Repositories.DepartmentRepository;
import com.example.EnocaChallenge.Services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
    @Override
    public ResponseEntity<Optional<Department>> findById(Integer departmentNo) {
        Optional<Department> findDepartment = departmentRepository.findById(departmentNo);
        if(findDepartment.isPresent()){
            return ResponseEntity.ok(findDepartment);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<String> save(Department newDepartment) {
        Optional<Department> department = departmentRepository.findById(newDepartment.getDepartmentNo());
        if(department.isPresent()){
            return new ResponseEntity<>("Kayıtlı bölüm bulundu.", HttpStatus.BAD_REQUEST);
        }
        departmentRepository.save(newDepartment);
        return new ResponseEntity<>("Yeni bölüm bilgileri eklendi.", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> update(Integer departmentNo, Department department) {
        Optional<Department> updateDepartment = departmentRepository.findById(department.getDepartmentNo());
        if(updateDepartment.isPresent()){
            departmentRepository.findById(departmentNo).ifPresent(newDepartment->{
                newDepartment.setDepartmentNo(department.getDepartmentNo());
                newDepartment.setDepartmentName(department.getDepartmentName());
                departmentRepository.save(newDepartment);
            });
            return new ResponseEntity<>("Bölüm bilgileri güncellendi", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Kayıtlı bölüm bulunamadı.",HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> delete(Integer departmentNo) {
        Optional<Department> department = departmentRepository.findById(departmentNo);
        if(department.isPresent()){
            departmentRepository.deleteById(departmentNo);
            return new ResponseEntity<>("Bölüm bilgisi silindi.",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Kayıtlı bölüm bulunamadı.",HttpStatus.BAD_REQUEST);
        }
    }
}
