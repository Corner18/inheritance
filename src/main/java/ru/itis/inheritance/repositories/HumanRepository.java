package ru.itis.inheritance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.inheritance.models.Human;

import java.util.Optional;


public interface HumanRepository extends JpaRepository<Human, Long> {
    Optional<Human> findByName(String name);
}
