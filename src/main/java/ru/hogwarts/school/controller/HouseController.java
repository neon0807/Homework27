package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
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

    @GetMapping("{/id}")
    public Faculty getFaculty(@PathVariable Long id){
        return houseService.readFaculty(id);
    }

    @PostMapping
    public Faculty creatFaculty(@RequestBody Faculty faculty){
        return houseService.creatFaculty(faculty);
    }

    @PutMapping
    public Faculty updateFaculty(@RequestBody Faculty faculty){
        return houseService.updateFaculty(faculty);
    }

    @DeleteMapping("{/id}")
    public Faculty deleteFaculty(@PathVariable Long id){
        return houseService.deleteFaculty(id);
    }

    @GetMapping("{/color}")
    public List<Faculty> getAge(@RequestParam String color){
        return houseService.getColor(color);
    }

}
