package com.example.task3.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "logins")
public class LoginUser {
    private String application;

    @Id
    private String appAccountName;

    private boolean isActive;
    private String jobTitle;
    private String department;


}
