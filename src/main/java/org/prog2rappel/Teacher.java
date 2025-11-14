package org.prog2rappel;

public class Teacher extends User{

    public enum speciality{
        FRONTEND,
        BACKEND,
        OPS,
        SYSADMIN
    }
    private speciality speciality;


    public Teacher(int id, String lastName, String firstName, java.time.Instant birthDate, String email, String phone, speciality speciality) {
        super(id, lastName, firstName, birthDate, email, phone);
        this.speciality = speciality ;
    }
}
