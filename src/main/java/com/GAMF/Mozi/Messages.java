package com.GAMF.Mozi;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;

@Entity
@Table(name="messages")

public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="email")
    private String email;
    @Column(name="message")
    private String message;
    private String date = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }


}
