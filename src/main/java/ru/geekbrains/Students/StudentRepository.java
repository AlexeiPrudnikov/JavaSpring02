package ru.geekbrains.Students;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class StudentRepository {
    private final List<Student> students;

    public StudentRepository() {
        students = new ArrayList<>();
        students.add(new Student("Ivanov", "Maths"));
        students.add(new Student("Petrov", "Sportsmans"));
        students.add(new Student("Sidorov", "Programmers"));
        students.add(new Student("Bulkin", "Maths"));
        students.add(new Student("Radulov", "Sportsmans"));
        students.add(new Student("Popov", "Programmers"));
        students.add(new Student("Leonov", "Maths"));
        students.add(new Student("Begunov", "Sportsmans"));
        students.add(new Student("Knut", "Programmers"));
    }
    public List<Student> getAll(){
        return List.copyOf(students);
    }
    public Student getByID(long id){
        return students.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }
    public List<Student> getByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students){
            if(student.getName().contains(name)) {
                result.add(student);
            }
        }
        return result;
    }
    public Student getStudentsByGroupName(String name) {
        return students.stream()
                .filter(it -> Objects.equals(it.getName(), name))
                .findFirst()
                .orElse(null);
    }
}
