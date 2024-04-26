package com.candenizgumus.springmovieapp.entities;

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
public class Movie {
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
    private List<Genre> genre;
    @OneToMany(mappedBy ="movie")
    private List<MovieComment> comment;
    @ManyToMany(mappedBy = "favmovie")
    private List<Kullanici> kullanici;

    @Override
    public String toString() {
        StringJoiner genreNames = new StringJoiner(", ", "[", "]");
        for (Genre genre : genre) {
            genreNames.add(genre.getName());
        }

        StringJoiner commentIds = new StringJoiner(", ", "[", "]");
        if (comment != null) {
            for (MovieComment movieComment : comment) {
                commentIds.add(String.valueOf(movieComment.getContent()));
            }
        }

        StringJoiner kullaniciIds = new StringJoiner(", ", "[", "]");
        if (kullanici != null) {
            for (Kullanici kullanici : kullanici) {
                kullaniciIds.add(String.valueOf(kullanici.getName()));
            }
        }

        return "Movie{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", rating=" + rating +
                ", summary='" + summary + '\'' +
                ", premiered=" + premiered +
                ", url='" + url + '\'' +
                ", genre=" + genreNames.toString() +
                ", comment=" + commentIds.toString() +
                ", kullanici=" + kullaniciIds.toString() +
                '}';
    }

}