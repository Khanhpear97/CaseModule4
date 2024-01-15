package com.example.casemodule4.model;


import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "username")
    private String username;

    private String password;

    private String email;

    private String name;

    private Long age;

    private String phone;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();
}
