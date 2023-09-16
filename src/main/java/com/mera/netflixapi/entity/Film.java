package com.mera.netflixapi.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "evaluation")
    private double evaluation;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "image")
    private String image;

    public Film() {}

    public Film(String name, double evaluation, String description, String category, String image, int rating_count, float rating_rate) {
        this.name = name;
        this.evaluation = evaluation;
        this.description = description;
        this.category = category;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(double evaluation) {
        this.evaluation = evaluation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
