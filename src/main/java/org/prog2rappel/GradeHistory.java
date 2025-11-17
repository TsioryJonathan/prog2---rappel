package org.prog2rappel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class GradeHistory {
    private double newValue;
    private String description;
    private Instant changeInstant;
}