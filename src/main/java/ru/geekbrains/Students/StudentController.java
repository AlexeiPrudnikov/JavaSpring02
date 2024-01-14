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
    public List<Student> getStudentsByName(@RequestParam String name) {
        return repository.getByName(name);
    }
    @GetMapping("/group")
    public List<Student> getStudentsByGroupName(@RequestParam String groupname) {
        return repository.getStudentsByGroupName(groupname);
    }
    @DeleteMapping (value = "/delete")
    public void deleteStudent(@RequestParam long id){
        repository.deleteById(id);
    }
    @PostMapping("/add")
    public void addStudent(@RequestParam String name, @RequestParam String groupname){
        Student student = new Student(name, groupname);
        repository.addStudent(student);
    }
}
