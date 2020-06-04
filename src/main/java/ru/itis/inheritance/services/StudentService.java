package ru.itis.inheritance.services;

import ru.itis.inheritance.dto.StudentDto;
import ru.itis.inheritance.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Optional<StudentDto> findById(Long id);
    Optional<StudentDto> findByName(String name);
    List<StudentDto> findAll();
    List<StudentDto> findAllByNameOfUniversity(String nameOfUniversity);
}
