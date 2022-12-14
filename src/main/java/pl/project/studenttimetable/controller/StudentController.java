package pl.project.studenttimetable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.studenttimetable.model.Student;
import pl.project.studenttimetable.service.StudentService;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Student>> getAll(){
        List<Student> students = service.getAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student student = service.getById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping(value = "/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        service.add(student);
        return ResponseEntity.ok(student);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
        Student student1 = service.getById(id);
        student1.setName(student.getName());
        student1.setSurname(student.getSurname());
        service.update(student1);
        return ResponseEntity.ok(student1);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
        Student student1 = service.getById(id);
        service.delete(student1);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
