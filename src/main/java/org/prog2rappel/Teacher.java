package org.prog2rappel;

import lombok.Data;

import java.util.Date;


@Data
public class Teacher extends User{
    public enum speciality{
        FRONTEND,
        BACKEND,
        OPS,
        SYSADMIN
    }
    private speciality speciality;
    public Teacher(int id, String lastName, String firstName, Date birthDate, String email, String phone, speciality speciality) {
        super(id, lastName, firstName, birthDate, email, phone);
        this.speciality = speciality ;
    }
}
