package org.engripaye.javabackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Expense {

    @Id @GeneratedValue
    private Long id;
    private String category;
    private Double amount;
    private LocalDate date;
}
