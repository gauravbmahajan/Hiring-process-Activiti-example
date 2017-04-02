package com.example.activitiDemo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Gaurav Mahajan on 25-03-2017.
 */

@Table(name = "applicant")
@Entity
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String email;

    private String phoneNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
