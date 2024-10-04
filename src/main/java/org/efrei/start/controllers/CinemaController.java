package org.efrei.start.controllers;

import org.efrei.start.dto.CreateCinema;
import org.efrei.start.models.Cinema;
import org.efrei.start.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    private final CinemaService service;

    @Autowired
    public CinemaController(CinemaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Cinema>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cinema> findById(@PathVariable String id) {
        Cinema cinema = service.findById(id);
        if (cinema == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cinema, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cinema> create(@RequestBody CreateCinema createCinema) {
        Cinema createdCinema = service.create(createCinema);
        return new ResponseEntity<>(createdCinema, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody CreateCinema createCinema) {
        service.update(id, createCinema);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        if (service.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
