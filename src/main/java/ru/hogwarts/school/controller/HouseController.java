package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.dto.FacultyDTO;
import ru.hogwarts.school.service.HouseService;

@RequestMapping("/faculty")
@RestController
public class HouseController {

    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/{id}")
    public FacultyDTO getFaculty(@PathVariable Long id){
        return houseService.readFaculty(id);
    }

    @PostMapping
    public FacultyDTO creatFaculty(@RequestBody FacultyDTO facultyDTO){
        return houseService.creatFaculty(facultyDTO.toFaculty());
    }

    @PutMapping
    public FacultyDTO updateFaculty(@RequestBody FacultyDTO facultyDTO){
        return houseService.updateFaculty(facultyDTO.toFaculty());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFaculty(@PathVariable Long id){
        houseService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public FacultyDTO getColor(@RequestParam (required = false) String color,
                               @RequestParam (required = false) String name) {
        if (name != null && !name.isBlank()) {
           return houseService.getName(name);
        }
        if ((color != null && color.isBlank())) {
            return houseService.getColor(color);
        }
        return null;
    }
}
