package com.github.jdchawla29.fake;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FakeCheckHistory {
    @Id
    @SequenceGenerator(name = "fake_id_sequence", sequenceName = "fake_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fake_id_sequence")
    private Integer id;
    private Integer studentId;
    private Boolean isFake;
    private LocalDateTime createdAt;
}
