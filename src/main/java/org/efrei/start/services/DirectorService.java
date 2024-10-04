package org.efrei.start.services;

import org.efrei.start.models.Director;
import org.efrei.start.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    private final DirectorRepository repository;

    @Autowired
    public DirectorService(DirectorRepository repository) {
        this.repository = repository;
    }

    public List<Director> findAll() {
        return repository.findAll();
    }

    public Director findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void create(Director director) {
        repository.save(director);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public void update(int id, Director director) {
        Director existingDirector = findById(id);
        if (existingDirector != null) {
            existingDirector.setNom(director.getNom());
            existingDirector.setPrenom(director.getPrenom());
            repository.save(existingDirector);
        }
    }
}
