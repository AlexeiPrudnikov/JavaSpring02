package ru.geekbrains.Students;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
