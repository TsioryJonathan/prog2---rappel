package org.prog2rappel;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Course {
    private int id;
    private String label;
    private int credit;
    private Teacher teacher;
    private List<Exam> exams;

}
