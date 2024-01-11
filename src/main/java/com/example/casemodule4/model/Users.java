package com.example.casemodule4.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Entity
@Table(name = "users")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> role;
}