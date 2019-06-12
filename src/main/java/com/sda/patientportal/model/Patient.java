package com.sda.patientportal.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "firstName")
    @Size(max = 20, min = 3)
    @Pattern(regexp = "^[A-Z].*")
    private String firstName;

    @Column(name = "lasttName")
    @Size(max = 20, min = 3)
    @Pattern(regexp = "^[A-Z].*")
    private String lastName;

    @Column(name = "age")
    @Min(value = 0)
    @Max(value = 100)
    private Integer age;


    @OneToMany(mappedBy = "sender", fetch = FetchType.EAGER)
    private List<Messages> messages;


    public Patient() {
    }

    public Patient(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Patient(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }
}
