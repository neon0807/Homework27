package ru.hogwarts.school.service;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import ru.hogwarts.school.dto.StudentDTO;
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

    public StudentDTO creatStudent(Student student){
        return StudentDTO.fromStudent(studentRepository.save(student));
    }

    public StudentDTO readStudent(Long id){
        return StudentDTO.fromStudent(studentRepository.findById(id).get());
    }

    public StudentDTO updateStudent(Student student){
        return StudentDTO.fromStudent(studentRepository.save(student));
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public List<Student> getAge(int age){
        return studentRepository.findStudentByAge(age);
    }

    public List<Student> getMinMaxAge(int min, int max){
        return studentRepository.findByAgeBetween(min, max);
    }

}
