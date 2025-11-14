package org.prog2rappel;

import java.util.Date;

public class Tutor extends User{
    private String linkWithStudent;

    public Tutor(int id, String lastName, String firstName, Date birthDate, String email, String phone, String linkWithStudent) {
        super(id, lastName, firstName, birthDate, email, phone);
        this.linkWithStudent = linkWithStudent;
    }
}
