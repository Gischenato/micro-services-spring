package com.gischenato.school;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;


    public void saveStudent(School student) {
        repository.save(student);
    }

    public List<School> getAllStudents() {
        return repository.findAll();
    }
}
