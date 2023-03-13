package ru.hogwarts.school.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.dto.StudentDTO;
import ru.hogwarts.school.model.Avatar;
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
    public Student readStudent(@PathVariable Long id){
        return studentService.readStudent(id);
    }

    @PostMapping
    public Student creatStudent(@RequestBody StudentDTO studentDTO){
        return studentService.creatStudent(studentDTO.toStudent());
    }

    @PutMapping
    public Student updateStudent(@RequestBody StudentDTO studentDTO){
        return studentService.updateStudent(studentDTO.toStudent());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Student> getAge(@RequestParam (required = false) int age,
                                @RequestParam (required = false) int min,
                                @RequestParam (required = false) int max){
        if (age != 0) {
            return studentService.getAge(age);
        }
        if (min != 0 && max != 0){
            return studentService.getMinMaxAge(min, max);
        }
        return null;
    }
}
