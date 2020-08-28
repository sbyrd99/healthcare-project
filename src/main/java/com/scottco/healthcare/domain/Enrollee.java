package com.scottco.healthcare.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import util.DateHandler;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Enrollee {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private boolean activated;
    private Date birthDate;
    private Integer phoneNumber;

    public Enrollee() {
    }
    public Enrollee(Integer id, String firstName, String lastName, boolean activated, Date birthDate, int phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.activated = activated;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @JsonDeserialize(using = DateHandler.class)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Enrollee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", activated=" + activated +
                ", birthDate=" + birthDate +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
