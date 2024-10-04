package org.efrei.start.models;

import jakarta.persistence.*;
import org.efrei.start.global.Category;

@Entity

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "title", nullable = false)
    private String title;

    @OneToOne
    private Actor actor;


    @Enumerated (EnumType.STRING)
    private Category category;




    public String getId() {
        return id;
    }
}
