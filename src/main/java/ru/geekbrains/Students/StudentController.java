package ru.geekbrains.Students;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Student> getUsers() {
        return repository.getAll();
    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable long id){
        return repository.getByID(id);
    }
    @GetMapping
    public List<Student> getUserByName(@RequestParam String name) {
        return repository.getByName(name);
    }
}
