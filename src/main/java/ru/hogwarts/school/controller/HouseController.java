package ru.hogwarts.school.controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.dto.FacultyDTO;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.HouseService;

import java.util.List;

@RequestMapping("/faculty")
@RestController
public class HouseController {

    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/{id}")
    public Faculty getFaculty(@PathVariable Long id){
        return houseService.readFaculty(id).toFaculty();
    }

    @PostMapping
    public Faculty creatFaculty(@RequestBody FacultyDTO facultyDTO){
        return houseService.creatFaculty(facultyDTO.toFaculty()).toFaculty();
    }

    @PutMapping
    public Faculty updateFaculty(@RequestBody FacultyDTO facultyDTO){
        return houseService.updateFaculty(facultyDTO.toFaculty()).toFaculty();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFaculty(@PathVariable Long id){
        houseService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Faculty getColor(@RequestParam (required = false) String color,
                            @RequestParam (required = false) String name) {
        if (name != null && !name.isBlank()) {
           return houseService.getName(name).toFaculty();
        }
        if ((color != null && color.isBlank())) {
            return houseService.getColor(color).toFaculty();
        }
        return null;
    }
}
