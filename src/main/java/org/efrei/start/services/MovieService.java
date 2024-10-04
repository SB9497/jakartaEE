package org.efrei.start.services;

import org.efrei.start.models.Actor;
import org.efrei.start.models.Movie;
import org.efrei.start.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {this.repository=repository;}

    public List<Movie> findAll() {return repository.findAll();}

    public void create(Movie movie){
        repository.save(movie) ;
    }

    public void deleteById(String id) {repository.deleteById(id);}


    public Movie findById(String id) {return repository.findById(id).orElse(null);}
}
