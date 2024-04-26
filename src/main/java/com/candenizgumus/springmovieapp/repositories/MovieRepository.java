package com.candenizgumus.springmovieapp.repositories;

import com.candenizgumus.springmovieapp.dto.response.MovieFindAllDto;
import com.candenizgumus.springmovieapp.dto.response.MovieFindByRatingAndCountDto;
import com.candenizgumus.springmovieapp.entities.Genre;
import com.candenizgumus.springmovieapp.entities.Kullanici;
import com.candenizgumus.springmovieapp.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>
{
    //Belli bir rating üzerindeki movieleri getirme
    List<Movie> findAllByRatingGreaterThan(double rating);

    //Belirli bir kullanıcının ilgi alanlarını kapsayan filmleri getiriniz.
    Movie findByKullanici(List<Kullanici> kullanici);
    List<Movie> findByGenre(List<Genre> genreList);

    List<Movie> findAllByPremieredBefore(LocalDate tarih);

    @Query("SELECT COUNT(m) as count , m.rating FROM Movie m WHERE m.rating =:rating GROUP BY m.rating")
    List<Object[]> findByRatingAndCount(double rating);

    Long countByRating(double rating);
}
