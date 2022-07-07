package com.github.jdchawla29.fake;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FakeCheckService {

    private final FakeCheckHistoryRepository fakeCheckHistoryRepository;

    public boolean isFakeStudent(Integer studentId) {
        fakeCheckHistoryRepository.save(
                FakeCheckHistory.builder()
                        .studentId(studentId)
                        .isFake(false)
                        .createdAt(LocalDateTime.now())
                        .build());
        return false;
    }
}
