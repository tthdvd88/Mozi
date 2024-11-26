package com.GAMF.Mozi;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.GenericGenerator;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.text.SimpleDateFormat;

@Entity
// @Table(name="messages")

public class Messages {

    @Id
    //hibernate verzió miatt kell
    @GeneratedValue(strategy = GenerationType.AUTO,generator="native")
    @GenericGenerator(name="native",strategy = "native")
    private int id = 1;
    @Column(name="email")
    private String email;
    @NotNull
    @Size(min=2, max=30)
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
