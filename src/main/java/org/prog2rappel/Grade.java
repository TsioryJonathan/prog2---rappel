package org.prog2rappel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Grade {
    private Student student;
    private Exam exam;
    private double initialValue;
    private List<GradeHistory> gradeHistory;
}