package ru.itis.inheritance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.inheritance.dto.HumanDto;
import ru.itis.inheritance.models.Human;
import ru.itis.inheritance.repositories.HumanRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HumanServiceImpl implements HumanService {

    @Autowired
    private HumanRepository humanRepository;


    @Override
    public HumanDto save(HumanDto humanDto) {
        Human human = humanRepository.save(Human.builder()
                .age(humanDto.getAge())
                .name(humanDto.getName())
                .build());
        return HumanDto.builder()
                .age(human.getAge())
                .name(human.getName())
                .id(human.getId())
                .build();
    }

    @Override
    public List<HumanDto> findAll() {
        return humanRepository.findAll().stream().map(
                human -> HumanDto.builder()
                        .id(human.getId())
                        .name(human.getName())
                        .age(human.getAge())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public Optional<HumanDto> findByName(String name) {
        Optional<Human> optionalHuman = humanRepository.findByName(name);
        if (optionalHuman.isPresent()) {
            Human human = optionalHuman.get();
            return Optional.of(HumanDto.builder()
                    .age(human.getAge())
                    .name(human.getName())
                    .id(human.getId())
                    .build());
        }
        return Optional.empty();
    }

    @Override
    public Optional<HumanDto> findById(Long id) {
        Optional<Human> optionalHuman = humanRepository.findById(id);
        if (optionalHuman.isPresent()) {
            Human human = optionalHuman.get();
            return Optional.of(HumanDto.builder()
                    .age(human.getAge())
                    .name(human.getName())
                    .id(human.getId())
                    .build());
        }
        return Optional.empty();
    }

}
