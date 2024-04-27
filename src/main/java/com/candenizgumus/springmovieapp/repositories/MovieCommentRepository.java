package com.candenizgumus.springmovieapp.repositories;

import com.candenizgumus.springmovieapp.entities.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieCommentRepository extends JpaRepository<MovieComment,Long>
{
    List<MovieComment> findAllByMovie_Id(Long movieId);
    List<MovieComment> findAllByMovie_IdAndDateBetween(Long movieId, LocalDate start, LocalDate finish);

    List<MovieComment> findAllByKullanici_Id(Long kullaniciId);
    List<MovieComment> findAllByKullanici_IdAndDateBetween(Long kullaniciId, LocalDate start, LocalDate finish);
    List<MovieComment> findAllByContentContaining(String metin);

    @Query("SELECT m FROM MovieComment m WHERE length(m.content)>:adet ")
    List<MovieComment> findAllByContentGreaterThan(int adet);

}
