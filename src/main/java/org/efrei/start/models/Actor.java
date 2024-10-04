package org.efrei.start.models;

import jakarta.persistence.*;

@Entity
@Table(name= "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "firstname")
    private String firstname;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Actor(String name, String firstname) {
        this.name=name;
        this.firstname=firstname;
    }

    public Actor(){

    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieId() {
        return movie != null ? movie.getId() : null;

    }

    public void setMovie(Movie movie) {
        this.movie = movie;

    }
}
