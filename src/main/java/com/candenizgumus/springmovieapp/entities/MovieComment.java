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
public class MovieComment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 500)
    String yorum;
    LocalDate yorumtarihi;
    @ManyToOne
    Movie movie;
    @ManyToOne
    Kullanici kullanici;

}
