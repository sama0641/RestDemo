package controller;

import model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@RestController

public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //HTTP GET metode for students
    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> studentsTempList = new ArrayList<>();
        studentRepository.findAll().forEach(studentsTempList::add);
        return ResponseEntity.status(HttpStatus.OK).body(studentsTempList);

    }




}
