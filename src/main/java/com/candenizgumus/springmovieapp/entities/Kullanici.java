package com.candenizgumus.springmovieapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tbluser")
public class Kullanici {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String surname;
    @Column(length = 50)
    private String email;
    @Column(length = 50)
    private String phone;
    @Column(length = 50)
    private String password;

    @ManyToMany()
    private List<Movie> favmovie;
    @ManyToMany()
    private List<Genre> favgenre;
    @OneToMany(mappedBy = "kullanici",cascade = CascadeType.PERSIST)
    private List<MovieComment> comment;
}