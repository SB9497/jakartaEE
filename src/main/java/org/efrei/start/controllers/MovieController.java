package org.efrei.start.controllers;

import org.efrei.start.models.Actor;
import org.efrei.start.models.Movie;
import org.efrei.start.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService service;
    @Autowired
    public MovieController(MovieService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Movie>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<?> create(@RequestBody Movie movie){
        service.create(movie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        Movie movie=service.findById(id);
        if (movie==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
