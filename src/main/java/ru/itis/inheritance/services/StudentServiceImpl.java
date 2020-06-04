package ru.itis.inheritance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.inheritance.dto.StudentDto;
import ru.itis.inheritance.models.Student;
import ru.itis.inheritance.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Optional<StudentDto> findById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            StudentDto studentDto = new StudentDto();
            studentDto.setName(student.getName());
            studentDto.setAge(student.getAge());
            studentDto.setNameOfUniversity(student.getNameOfUniversity());
            studentDto.setId(student.getId());
            return Optional.of(studentDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<StudentDto> findByName(String name) {
        Optional<Student> optionalStudent = studentRepository.findByName(name);
        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            StudentDto studentDto = new StudentDto();
            studentDto.setName(student.getName());
            studentDto.setAge(student.getAge());
            studentDto.setNameOfUniversity(student.getNameOfUniversity());
            studentDto.setId(student.getId());
            return Optional.of(studentDto);
        }
        return Optional.empty();
    }

    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream().map(
                student -> {
                    StudentDto studentDto = new StudentDto();
                    studentDto.setName(student.getName());
                    studentDto.setAge(student.getAge());
                    studentDto.setNameOfUniversity(student.getNameOfUniversity());
                    studentDto.setId(student.getId());
                    return studentDto;
                }
        ).collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> findAllByNameOfUniversity(String nameOfUniversity) {
        return studentRepository.findByNameOfUniversity(nameOfUniversity).stream().map(
                student -> {
                    StudentDto studentDto = new StudentDto();
                    studentDto.setName(student.getName());
                    studentDto.setAge(student.getAge());
                    studentDto.setNameOfUniversity(student.getNameOfUniversity());
                    studentDto.setId(student.getId());
                    return studentDto;
                }
        ).collect(Collectors.toList());
    }
}
