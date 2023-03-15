package ru.hogwarts.school.service;

import org.springframework.data.domain.PageRequest;
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

    public List<Student> getAge(Integer pageNumber, Integer pageSize, int age){
        if (pageSize > 50 || pageSize < 1 ) pageSize = 50;
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return studentRepository.findStudentByAge(age);
    }

    public List<Student> getMinMaxAge(Integer pageNumber, Integer pageSize,int min, int max){
        if (pageSize > 50 || pageSize < 1 ) pageSize = 50;
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return studentRepository.findByAgeBetween(min, max);
    }

    public Long getTotalStudentsCount(){
        return studentRepository.getTotalStudentsCount();
    }

    public Long getAverageAge(){
        return studentRepository.getAverageAge();
    }

    public List<Student> getFiveYoungestStudent(){
        return studentRepository.getFiveYoungestStudent();
    }

}
