import org.prog2rappel.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.prog2rappel.Teacher.speciality.BACKEND;

public class GradeTest {

    private Student jonathan, colombe;
    private Course PROG2, WEB2;
    private Exam e1, e2;
    private MainApp mainApp;

    private final Instant instantChange = Instant.parse("2025-01-25T14:00:00Z");
    private final Instant finalChange = Instant.parse("2025-03-20T10:00:00Z");

    @BeforeEach
    void setUp() {
        Tutor rakoto = new Tutor(3, "RAKOTO", "Blooky", LocalDate.of(1980, 10, 1), "blooky@hei.school", "0345130557", "Parent");
        jonathan = new Student(1, "RAKOTOARISOA", "Tsiory Jonathan", LocalDate.of(2007, 7, 10), "hei.jonathan.3@gmail.com", "0374320510", "K1", rakoto);
        colombe = new Student(2, "RAKOTONJANAHARY", "Fiorenampitia Colombe", LocalDate.of(2007, 4, 7), "hei.colombe@gmail.com", "0383897164", "K1", rakoto);

        Teacher teach1 = new Teacher(5, "RAMAROZAKA", "Tokimahery", LocalDate.of(1990, 10, 25), "toky@mail.hei.school", "0380098765", BACKEND);
        PROG2 = new Course(20, "PROG2", 5, teach1);
        WEB2 = new Course(301, "WEB2", 3, teach1);

        e1 = new Exam(400, "Midterm", PROG2, Instant.parse("2025-01-15T09:00:00Z"), 3);
        e2 = new Exam(401, "Final", PROG2, Instant.parse("2025-03-10T09:00:00Z"), 5);

        GradeHistory h1 = new GradeHistory(19.5, "Correction erreur", instantChange);

        Grade g1 = new Grade(jonathan, e1, 18.0, List.of(h1));
        Grade g2 = new Grade(jonathan, e2, 15.0, new ArrayList<>());

        List<Grade> allGrades = List.of(g1, g2);
        mainApp = new MainApp(allGrades);
    }


    @Test
    void CalculatesWeightedAverageAtFinalTime() {
        double grade_e1_at_finalChange = mainApp.getExamGrade(e1, jonathan, finalChange);
        double grade_e2_at_finalChange = mainApp.getExamGrade(e2, jonathan, finalChange);

        assertEquals(19.5, grade_e1_at_finalChange);
        assertEquals(15.0, grade_e2_at_finalChange);

        double courseGrade = mainApp.getCourseGrade(PROG2, jonathan, finalChange);

        double expected = (19.5 * 3) + (15.0 * 5);
        double totalCoeff = 3 + 5;
        double expectedAverage = 133.5 / 8.0;

        assertEquals(16.6875, courseGrade);
    }

    @Test
    void CalculatesAverageBeforeChange() {
        Instant timeBeforeChange = instantChange.minusSeconds(3600);
        double courseGrade = mainApp.getCourseGrade(PROG2, jonathan, timeBeforeChange);

        double grade1 = 18.0;
        double grade2 = 15.0;

        double expected = (grade1 * 3) + (grade2 * 5);
        double totalCoeff = 3 + 5; // 8
        double expectedAverage = 129.0 / 8.0;

        assertEquals(16.125, courseGrade);
    }

}