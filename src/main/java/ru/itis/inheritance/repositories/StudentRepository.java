package ru.itis.inheritance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.inheritance.models.Student;


import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameOfUniversity(String nameOfUniversity);
    Optional<Student> findByName(String name);
}
