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
@Table(name = "tblkullanici")
public class Kullanici
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 50)
    String name;
    @Column(length = 50)
    String surname;
    @Column(length = 50)
    String email;
    @Column(length = 15)
    String phone;
    @Column(length = 32)
    String password;
    @ManyToMany (mappedBy = "kullanici")
    List<Movie> favmovie;
    @ManyToMany (mappedBy = "genre")
    List<Genre> favgenre;

}
