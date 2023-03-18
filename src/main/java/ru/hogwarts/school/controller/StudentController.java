package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.dto.StudentDTO;
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


    @GetMapping("/{id}")
    public StudentDTO readStudent(@PathVariable Long id){
        return studentService.readStudent(id);
    }

    @PostMapping
    public StudentDTO creatStudent(@RequestBody StudentDTO studentDTO){
        return studentService.creatStudent(studentDTO.toStudent());
    }

    @PutMapping
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO){
        return studentService.updateStudent(studentDTO.toStudent());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Student> getAge(@RequestParam ("page") Integer pageNumber,
                                @RequestParam ("size") Integer pageSize,
                                @RequestParam (required = false) int age,
                                @RequestParam (required = false) int min,
                                @RequestParam (required = false) int max){
        if (age != 0) {
            return studentService.getAge(pageNumber, pageSize, age);
        }
        if (min != 0 && max != 0){
            return studentService.getMinMaxAge(pageNumber, pageSize, min, max);
        }
        return null;
    }

    @GetMapping
    public Long getTotalStudentsCount(){
        return studentService.getTotalStudentsCount();
    }

    @GetMapping
    public Long getAverageAge(){
        return studentService.getAverageAge();
    }

    @GetMapping
    public List<Student> getFiveYoungestStudent(){
        return studentService.getFiveYoungestStudent();
    }
}
