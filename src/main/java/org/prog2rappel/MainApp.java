package org.prog2rappel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class MainApp {
    private final List<Grade> allGrades;

    public double getExamGrade(Exam exam, Student student, Instant t) {
        Optional<Grade> matchingGrade = allGrades.stream()
                .filter(grade -> grade.getStudent().equals(student) && grade.getExam().equals(exam))
                .findFirst();

        if (matchingGrade.isEmpty()) {
            throw new IllegalStateException("No grade found for student " + student + " and exam " + exam);
        }

        Grade grade = matchingGrade.get();

        Optional<GradeHistory> lastChangeBeforeT = grade.getGradeHistory().stream()
                .filter(historyEntry -> !historyEntry.getChangeInstant().isAfter(t))
                .max(Comparator.comparing(GradeHistory::getChangeInstant));

        if (lastChangeBeforeT.isPresent()) {
            return lastChangeBeforeT.get().getNewValue();
        } else {
            return grade.getInitialValue();
        }
    }

    public double getCourseGrade(Course course, Student student, Instant t) {
        List<Exam> examsForCourse = allGrades.stream()
                .filter(grade -> grade.getStudent().equals(student))
                .map(Grade::getExam)
                .filter(exam -> exam.getCourse().equals(course))
                .distinct()
                .toList();

        if (examsForCourse.isEmpty()) {
            throw new IllegalArgumentException("No exam found for student " + student + " and course " + course);
        }

        double totalWeightedPoints = 0.0;
        double totalCoefficients = 0.0;

        for (Exam exam : examsForCourse) {
            double grade = getExamGrade(exam, student, t);
            int coeff = exam.getCoeff();

            totalWeightedPoints += grade * coeff;
            totalCoefficients += coeff;
        }

        if (totalCoefficients == 0) {
            return 0.0;
        }

        return totalWeightedPoints / totalCoefficients;
    }
}