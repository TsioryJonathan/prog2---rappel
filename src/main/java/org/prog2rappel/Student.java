package org.prog2rappel;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student extends User {
    private String group;
    private Tutor tutor;

    public Student(int id, String lastName, String firstName, LocalDate birthDate, String email, String phone, String group, Tutor tutor) {
        super(id, lastName, firstName, birthDate, email, phone);
        this.group = group;
        this.tutor = tutor;
    }
}