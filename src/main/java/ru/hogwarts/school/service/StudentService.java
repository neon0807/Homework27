package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestParam;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentService {
    private final HashMap<Long, Student> students= new HashMap<>();
    private Long id = 0L;

    public Student creatStudent(Student student){
        student.setId(id);
        students.put(id, student);
        return student;
    }

    public Student readStudent(Long id){
        return students.get(id);
    }

    public Student updateStudent(Student student){
        students.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(Long id){
        return students.remove(id);
    }

    public List<Student> getAge(int age){
        Stream<Student> stream = students.values().stream();
        stream = stream.filter(student -> age == student.getAge());
        return stream.collect(Collectors.toList());
    }
}
