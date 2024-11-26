package com.GAMF.Mozi;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="film")
public class Film {

    @Id
    private long fkod;
    @Column(name="filmcim")
    private String filmcim;
    private String mufaj;
    private int hossz;

    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        },
            mappedBy = "filmek")

    private Set<Mozi> mozik = new HashSet<>();

    public Film() {

    }

    public long getFkod() {
        return fkod;
    }

    public void setFkod(long fkod) {
        this.fkod = fkod;
    }

    public String getFilmcim() {
        return filmcim;
    }

    public void setFilmcim(String filmcim) {
        this.filmcim = filmcim;
    }

    public String getMufaj() {
        return mufaj;
    }

    public void setMufaj(String mufaj) {
        this.mufaj = mufaj;
    }

    public int getHossz() {
        return hossz;
    }

    public void setHossz(int hossz) {
        this.hossz = hossz;
    }


}
