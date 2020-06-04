package ru.itis.inheritance.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(schema = "inherit", name = "student")
public class Student extends Human {
    private String nameOfUniversity;
}
