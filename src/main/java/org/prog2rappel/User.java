package org.prog2rappel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class User {
    private int id;
    private String lastName;
    private String firstName;
    private Instant birthDate;
    private String email;
    private String phone;
}
