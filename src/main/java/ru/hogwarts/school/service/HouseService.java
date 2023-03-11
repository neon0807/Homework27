package ru.hogwarts.school.service;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class HouseService {

    private final FacultyRepository facultyRepository;

    public HouseService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    public Faculty creatFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }


    public Faculty readFaculty(Long id){
        return facultyRepository.getById(id);
    }


    public Faculty updateFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }


    public void deleteFaculty(Long id){
        facultyRepository.deleteById(id);
    }

    public List<Faculty> getColor(String color){
        return facultyRepository.findFacultiesByColor(color);
    }

}
