package ru.hogwarts.school.service;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import ru.hogwarts.school.model.Student;

import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student creatStudent(Student student){
        return studentRepository.save(student);
    }

    public Student readStudent(Long id){
        return studentRepository.getById(id);
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public List<Student> getAge(int age){
        return studentRepository.findStudentByAge(age);
    }

}
