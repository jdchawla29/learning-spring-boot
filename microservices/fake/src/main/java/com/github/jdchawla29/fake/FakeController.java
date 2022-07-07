package com.github.jdchawla29.fake;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/v1/fake-check")
@AllArgsConstructor
@Slf4j
public class FakeController {

    private final FakeCheckService fakeCheckService;

    @GetMapping(path = "{studentId}")
    public FakeCheckResponse isFakeId(
            @PathVariable("studentId") Integer studentId) {
        boolean isFakeStudent = fakeCheckService
                .isFakeStudent(studentId);
        log.info("fake check request for student {}", studentId);
        
        return new FakeCheckResponse(isFakeStudent);
    }

}
