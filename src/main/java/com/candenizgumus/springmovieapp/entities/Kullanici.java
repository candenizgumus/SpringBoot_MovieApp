package com.candenizgumus.springmovieapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Validated
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
    @Email
    private String email;
    @Column(length = 50)
    @Size(min = 10, max = 200, message
            = "Phone no min 10 karakter olmalı")
    private String phone;
    @Column(length = 50)
    private String password;

    @ManyToMany()
    @JsonIgnore
    private List<Movie> favmovie;
    @ManyToMany()
    @JsonIgnore
    private List<Genre> favgenre;
    @JsonIgnore
    @OneToMany(mappedBy = "kullanici",cascade = CascadeType.PERSIST)
    private List<MovieComment> comment;
}