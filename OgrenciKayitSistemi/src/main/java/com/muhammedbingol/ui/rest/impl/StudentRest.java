package com.muhammedbingol.ui.rest.impl;


import com.muhammedbingol.business.dto.StudentDto;
import com.muhammedbingol.business.services.StudentServices;
import com.muhammedbingol.ui.rest.IStudentRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class StudentRest implements IStudentRest {

    @Autowired
    StudentServices services;

    //ROOT
    //http://localhost:8080/api/v1
    //http://localhost:8080/api/v1/index
    @GetMapping({"/", "/index"})
    public String getRoot(){
        return "index";
    }

    //SAVE
    //http://localhost:8080/api/v1/students
    @Override
    @PostMapping("/students")
    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        services.createStudent(studentDto);
        return studentDto;
    }


    //LIST
    //http://localhost:8080/api/v1/students
    @Override
    @GetMapping("/students")
    public List<StudentDto> getAllStudents() {
        List<StudentDto> list =services.getAllStudents();
        return list;
    }


    //FIND
    //http://localhost:8080/api/v1/students/1
    @Override
    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(name = "id") Long id) throws Throwable {
        ResponseEntity<StudentDto> entity =services.getStudentById(id);
        return entity;
    }

    //UPDATE
    //http://localhost:8080/api/v1/students/1
    @Override
    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable(name = "id") Long id, @RequestBody StudentDto studentDto) throws Throwable {
        services.updateStudent(id,studentDto);
        return ResponseEntity.ok(studentDto);
    }

    //DELETE
    //http://localhost:8080/api/v1/students/1
    @Override
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable(name = "id") Long id)  {

        services.deleteStudent(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
