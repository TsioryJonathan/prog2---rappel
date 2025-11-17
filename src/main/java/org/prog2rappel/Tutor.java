package org.prog2rappel;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Tutor extends User{
    private String linkWithStudent;

    public Tutor(int id, String lastName, String firstName, LocalDate birthDate, String email, String phone, String linkWithStudent) {
        super(id, lastName, firstName, birthDate, email, phone);
        this.linkWithStudent = linkWithStudent;
    }
}
