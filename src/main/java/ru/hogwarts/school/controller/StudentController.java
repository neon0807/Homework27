package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;


@RequestMapping("/student")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("{id}")
    public Student getStudent(@PathVariable Long id){
        return studentService.readStudent(id);
    }

    @PostMapping
    public Student creatStudent(@RequestBody Student student){
        return studentService.creatStudent(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("{id}")
    public Student deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("{age}")
    public List<Student> getAge(@RequestParam int age){
        return studentService.getAge(age);
    }
}
