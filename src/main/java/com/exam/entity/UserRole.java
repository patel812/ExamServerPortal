package com.exam.entity;

import jakarta.persistence.*;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;


    //User
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    //Role
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;




}
