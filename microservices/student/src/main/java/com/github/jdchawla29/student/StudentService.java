package com.github.jdchawla29.student;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final RestTemplate restTemplate;

    public void registerStudent(StudentRegistrationRequest request) {
        Student student = Student.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // todo: check if email valid
        // todo: check if email not taken
        studentRepository.saveAndFlush(student);
        // todo: check if fake
        FakeCheckResponse fakeCheckResponse = restTemplate.getForObject(
                "http://FAKE/api/v1/fake-check/{customerId}",
                FakeCheckResponse.class,
                student.getId());

        if (fakeCheckResponse.isFake()){
            throw new IllegalStateException("Fake");
        }
        // todo: send notification
    }
}
