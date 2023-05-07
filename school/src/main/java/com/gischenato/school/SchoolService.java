package com.gischenato.school;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gischenato.school.clients.StudentClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;
    private final StudentClient client;


    public void saveStudent(School student) {
        repository.save(student);
    }

    public List<School> getAllStudents() {
        return repository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        var school = repository.findById(schoolId)
                                .orElse(
                                    School.builder()
                                    .name("NOT_FOUND")
                                    .email("NOT_FOUND")
                                    .build()
                                );

        var students = client.findAllStudentsBySchool(schoolId);

        return FullSchoolResponse.builder()
        .name(school.getName())
        .email(school.getEmail())
        .students(students)
        .build();
    }    
}
