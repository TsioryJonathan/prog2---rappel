package org.prog2rappel;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class Exam {
    private int id;
    private String title;
    private Course course;
    private LocalDate date;
    private int coeff;
    private List<Grade> grades;
}
