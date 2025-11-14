package org.prog2rappel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String lastName;
    private String firstName;
    private Date birthDate;
    private String email;
    private String phone;
}
