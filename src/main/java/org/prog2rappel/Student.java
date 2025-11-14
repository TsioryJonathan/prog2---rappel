package org.prog2rappel;

import java.time.Instant;

public class Student extends User {
    private String group;

    public Student(int id, String lastName, String firstName, Instant birthDate, String email, String phone, String group) {
        super(id, lastName, firstName, birthDate, email, phone);
        this.group = group;
    }
}
