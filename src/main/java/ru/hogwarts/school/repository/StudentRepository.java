package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.dto.StudentDTO;
import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentByAge(int age);
    List<Student> findByAgeBetween(int min, int max);
    @Query(value = "SELECT COUNT(s) AS count from student AS s", nativeQuery = true)
    Long getTotalStudentsCount();
    @Query(value = "SELECT AVG(s.age) FROM student AS s",nativeQuery = true)
    Long getAverageAge();
    @Query(value = "SELECT * FROM student ORDER BY age ASC LIMIT 5", nativeQuery = true)
    List<Student> getFiveYoungestStudent();

}
