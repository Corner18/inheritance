package ru.itis.inheritance.services;

import ru.itis.inheritance.dto.HumanDto;

import java.util.List;
import java.util.Optional;

public interface HumanService {
    HumanDto save(HumanDto humanDto);
    List<HumanDto> findAll();
    Optional<HumanDto> findByName(String name);
    Optional<HumanDto> findById(Long id);
}
