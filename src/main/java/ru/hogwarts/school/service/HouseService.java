package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class HouseService {
    private final HashMap<Long, Faculty> houses = new HashMap<>();
    private Long id = 0L;


    public Faculty creatFaculty(Faculty faculty){
        faculty.setId(id);
        houses.put(id,faculty);
        return faculty;
    }


    public Faculty readFaculty(Long id){
        return houses.get(id);
    }


    public Faculty updateFaculty(Faculty faculty){
        houses.put(faculty.getId(), faculty);
        return faculty;
    }


    public Faculty deleteFaculty(Long id){
        return houses.remove(id);
    }

    public List<Faculty> getColor(String colol){
        Stream<Faculty> stream = houses.values().stream();
        stream = stream.filter(houses -> colol.equals(houses.getColor()));
        return stream.collect(Collectors.toList());
    }
}
