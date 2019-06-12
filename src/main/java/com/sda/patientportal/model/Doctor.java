package com.sda.patientportal.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "hospital")
    private String hospital;


    @OneToMany(mappedBy = "receiver", fetch = FetchType.EAGER)
    private List<Messages> messages;


    public Doctor() {
    }

    public Doctor(Long id, String firstName, String lastName, String hospital) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hospital = hospital;
    }

    public Doctor(String firstName, String lastName, String hospital) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hospital = hospital;
    }

    public Doctor(String firstName, String lastName) {
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

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }
}
