package com.scottco.healthcare.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import util.DateHandler;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Dependent {
    @Id
    private Integer id;
    private Integer enrolleeId;
    private String firstName;
    private String lastName;
    private Date birthDate;

    public Dependent() {
    }
    public Dependent(Integer id, Integer enrolleeId, String firstName, String lastName, Date birthDate) {
        this.id = id;
        this.enrolleeId = enrolleeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnrolleeId() {
        return enrolleeId;
    }

    public void setEnrolleeId(Integer enrolleeId) {
        this.enrolleeId = enrolleeId;
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
    @JsonDeserialize(using = DateHandler.class)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Dependent{" +
                "id=" + id +
                ", enrolleeId=" + enrolleeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
