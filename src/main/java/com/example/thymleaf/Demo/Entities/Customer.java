package com.example.thymleaf.Demo.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cName;
    private String cAddress;
    private String cGender;
    private String cEmail;
    private String cPassword;
}
