package org.efrei.start.services;

import org.efrei.start.dto.CreateCinema;
import org.efrei.start.models.Cinema;
import org.efrei.start.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CinemaService {

    private final CinemaRepository repository;

    @Autowired
    public CinemaService(CinemaRepository repository) {
        this.repository = repository;
    }

    public List<Cinema> findAll() {
        return repository.findAll();
    }

    public Cinema findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Cinema create(CreateCinema createCinema) {
        Cinema cinema = new Cinema();
        cinema.setRoomNumber(createCinema.getRoomNumber());
        cinema.setShowTime(createCinema.getShowTime());
        return repository.save(cinema);
    }

    public void update(String id, CreateCinema createCinema) {
        Cinema cinema = repository.findById(id).orElse(null);
        if (cinema != null) {
            cinema.setRoomNumber(createCinema.getRoomNumber());
            cinema.setShowTime(createCinema.getShowTime());
            repository.save(cinema);
        }
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
