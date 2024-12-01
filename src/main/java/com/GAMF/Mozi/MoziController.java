package com.GAMF.Mozi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoziController {

    private final MoziRepo repo;
    public MoziController(MoziRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/mozik")
    Iterable<Mozi> mozik() {
        return repo.findAll();
    }

    @GetMapping("/mozi/{id}")
    Mozi mozi(@PathVariable int id) {
        return repo.findById(id).get();
    }
}
