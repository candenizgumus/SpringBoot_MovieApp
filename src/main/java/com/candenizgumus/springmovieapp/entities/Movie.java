package com.candenizgumus.springmovieapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

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
    Long id;
    @ManyToMany(mappedBy = "movie", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    List<Genre> genre;
    String language;
    String image;
    String name;
    String country;
    Integer rating;
    @Column(length = 2052)
    String summary;
    LocalDate premired;
    String url;
    @OneToMany(mappedBy = "movie" , cascade = CascadeType.PERSIST , fetch = FetchType.EAGER )
    List<MovieComment> moviecomment;
    @ManyToMany
    List<Kullanici> kullanici;

}
