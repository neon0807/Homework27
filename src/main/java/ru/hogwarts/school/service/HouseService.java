package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;

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
}
