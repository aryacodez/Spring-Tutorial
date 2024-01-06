package com.example.springboot.controller;

import java.util.*;
import com.example.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
public class StudentController {


    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1,"Sam","Folker");
        return student;
    }

    @GetMapping("/student-list")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"SAM","Folker"));
        students.add(new Student(2,"RAM","Folker"));
        students.add(new Student(3,"JAM","Folker"));
        return students;
    }

    //handle @PathVariable
    @GetMapping("/student/{id}")
    public Student studentPathVariable(@PathVariable("id") int id){
        return new Student(id,"SAM","Folker");
    }

    //REST API with RequestParam
    // http://localhost:8080/student/query?id=1&firstName=SAM
    @GetMapping("students/query")
    public Student studentRequest(@RequestParam int id,@RequestParam String firstName){
        return new Student(id,firstName,"Folker");
    }

    //POST REQUEST
    @PostMapping("/create/students")
    @ResponseStatus(HttpStatus.CREATED)
    public  Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //Update Request
    @PutMapping("/update/students/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int id){
        System.out.println((student.getFirstName()));
        System.out.println(student.getLastName());
        return student;
    }

    //Delete Request
    @DeleteMapping("/delete/students/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "Deleted Successfully";
    }

    //Use ResponseEntity
    @GetMapping("/students")
    public ResponseEntity<Student> getStu(){
        Student student = new Student(1,"Sam","Folker");
//        return new ResponseEntity<>(student,HttpStatus.OK);
        return ResponseEntity.ok().header(
                "custom-header",
                "ram"
        ).body(student);
    }

    @GetMapping("/students-list")
    public ResponseEntity<List<Student>> getStud(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"SAM","Folker"));
        students.add(new Student(2,"RAM","Folker"));
        students.add(new Student(3,"JAM","Folker"));
        return ResponseEntity.ok(students);
    }
}
