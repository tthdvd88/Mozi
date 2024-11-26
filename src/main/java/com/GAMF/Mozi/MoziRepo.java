package com.GAMF.Mozi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MoziRepo extends JpaRepository<Mozi,Integer> {

    List<Mozi> findMoziByMoziazon(Long moziazon);

}
