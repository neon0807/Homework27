package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;

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
}
