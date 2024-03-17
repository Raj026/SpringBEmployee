package com.rapa.springdev.springdev;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="emp_db1")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String phone;
    private String email;
}
