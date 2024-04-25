package com.candenizgumus.springmovieapp.entities;

import com.candenizgumus.springmovieapp.services.KullaniciService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblmoviecomment")
public class MovieComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 2048)
    private String content;
    @Builder.Default
    private LocalDate date=LocalDate.now();
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Kullanici kullanici;
}