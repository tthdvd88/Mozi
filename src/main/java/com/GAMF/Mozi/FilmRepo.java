package com.GAMF.Mozi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepo extends JpaRepository<Film,Long> {

    List<Film> findMoziByFkod(Long fkod);

}
