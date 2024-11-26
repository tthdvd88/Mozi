package com.GAMF.Mozi;

import jakarta.persistence.*;
import org.hibernate.mapping.Join;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="mozi")
public class Mozi {

    @Id
    private Long moziazon;
    private String mozinev;

   @ManyToMany(fetch = FetchType.LAZY,
    cascade = {
           CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(name="hely",
        joinColumns = {@JoinColumn(name="moziazon")},
        inverseJoinColumns = {@JoinColumn(name="fkod")})
    private Set<Film> filmek = new HashSet<>();

    public Mozi (){

    }

    public Mozi(Long moziazon, String mozinev){
        this.moziazon = moziazon;
        this.mozinev = mozinev;
    }

    public Long getMoziazon() {
        return moziazon;
    }

    public void setMoziazon(Long moziazon) {
        this.moziazon = moziazon;
    }

    public String getMozinev() {
        return mozinev;
    }

    public void setMozinev(String mozinev) {
        this.mozinev = mozinev;
    }


}


