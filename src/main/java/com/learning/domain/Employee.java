package com.learning.domain;

import javax.json.bind.annotation.JsonbTransient;

public class Employee {

    @JsonbTransient
    Long Id;
    String firstName;
    String LastName;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName) {
        Id = id;
        this.firstName = firstName;
        LastName = lastName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
