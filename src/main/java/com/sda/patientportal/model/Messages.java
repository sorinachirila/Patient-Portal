package com.sda.patientportal.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "message")
public class Messages {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient sender;


    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor receiver;

    @Column
    @CreationTimestamp
    private Timestamp sendTime;

    @Column(name = "updateTime")
    @UpdateTimestamp
    private Timestamp updateTime;

/*    public Messages(Long id, String question, String answer, Patient sender, Doctor receiver) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.sender = sender;
        this.receiver = receiver;
    }*/

    public Messages() {
    }

 /*   public Messages(String question, String answer, Patient sender, Doctor receiver) {
        this.question = question;
        this.answer = answer;
        this.sender = sender;
        this.receiver = receiver;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Patient getSender() {
        return sender;
    }

    public void setSender(Patient sender) {
        this.sender = sender;
    }

    public Doctor getReceiver() {
        return receiver;
    }

    public void setReceiver(Doctor receiver) {
        this.receiver = receiver;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

}
