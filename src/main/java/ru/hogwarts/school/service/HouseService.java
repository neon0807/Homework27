package ru.hogwarts.school.service;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.dto.FacultyDTO;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class HouseService {

    private  FacultyRepository facultyRepository;

    public HouseService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    public FacultyDTO creatFaculty(Faculty faculty){
        return FacultyDTO.fromFaculty(facultyRepository.save(faculty));
    }


    public FacultyDTO readFaculty(Long id){
        return FacultyDTO.fromFaculty(facultyRepository.findById(id).get());
    }


    public FacultyDTO updateFaculty(Faculty faculty){
        return FacultyDTO.fromFaculty(facultyRepository.save(faculty));
    }


    public void deleteFaculty(Long id){
        facultyRepository.deleteById(id);
    }

    public FacultyDTO getColor(String color){
        return FacultyDTO.fromFaculty(facultyRepository.findFacultiesByColor(color));
    }

    public FacultyDTO getName(String name){
        return FacultyDTO.fromFaculty(facultyRepository.findFacultiesByNameIgnoreCase(name));
    }

}
