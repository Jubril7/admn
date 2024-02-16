package com.nxgdemo.entity;

import com.nxgdemo.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "usering")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private UserType userType;
}
