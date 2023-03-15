package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findFacultiesByColor(String color);
    Faculty findFacultiesByNameIgnoreCase(String name);


}
