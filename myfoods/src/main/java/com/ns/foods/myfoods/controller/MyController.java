package com.ns.foods.myfoods.controller;


import com.ns.foods.myfoods.StudentRepository;
import com.ns.foods.myfoods.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class MyController {

    @Autowired
    private StudentRepository studentRepository;


    @PostMapping("/add")
    public String addStudent(@RequestBody Student student)
    {
        Student save = this.studentRepository.save(student);
        return "Student Added Successfully";
    }



    @GetMapping("/getAll")
    public ResponseEntity<?> getStudents()
    {
        // get as name inside object
        List<Student> students = studentRepository.findAll();
        Map<String, List<Student>> response = new HashMap<>();
        response.put("students", students);
        return ResponseEntity.ok(response);

        // get as objects
//        return ResponseEntity.ok(this.studentRepository.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id) {


        if (!studentRepository.existsById(Integer.valueOf(id))) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\": \"error\", \"message\": \"Failed to delete student with ID " + id + ". Error: " + "\"}");
        }
        studentRepository.deleteById(Integer.valueOf(id));
        return ResponseEntity.ok().body("{\"status\": \"success\", \"message\": \"Student with ID " + id + " has been deleted successfully.\"}");
    }

}


