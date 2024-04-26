package com.candenizgumus.springmovieapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.StringJoiner;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblmovie")
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String language;
    private String image;
    private String name;
    private String country;
    private double rating;
    @Column(length = 2048)
    private String summary;
    private LocalDate premiered;
    private String url;
    @ManyToMany()
    @JsonIgnore
    private List<Genre> genre;
    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<MovieComment> comment;
    @ManyToMany(mappedBy = "favmovie")
    @JsonIgnore
    private List<Kullanici> kullanici;


}