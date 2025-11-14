package org.prog2rappel;

public class Tutor extends User{
    private String linkWithStudent;

    public Tutor(int id, String lastName, String firstName, java.time.Instant birthDate, String email, String phone, String linkWithStudent) {
        super(id, lastName, firstName, birthDate, email, phone);
        this.linkWithStudent = linkWithStudent;
    }
}
