package org.prog2rappel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Exam {
    private int id;
    private String title;
    private Course course;
    private Instant date;
    private int coeff;
}