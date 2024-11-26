package com.GAMF.Mozi;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="hely")
public class Hely {

    @Id
    private int moziazon;
    private int fkod;



    public int getMoziazon() {
        return moziazon;
    }

    public void setMoziazon(int moziazon) {
        this.moziazon = moziazon;
    }

    public int getFkod() {
        return fkod;
    }

    public void setFkod(int fkod) {
        this.fkod = fkod;
    }

}
