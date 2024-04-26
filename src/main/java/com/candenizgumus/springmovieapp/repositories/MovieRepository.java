package com.candenizgumus.springmovieapp.repositories;

import com.candenizgumus.springmovieapp.entities.Kullanici;
import com.candenizgumus.springmovieapp.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>
{
    //Belli bir rating üzerindeki movieleri getirme
    List<Movie> findAllByRatingGreaterThan(double rating);

    //Belirli bir kullanıcının ilgi alanlarını kapsayan filmleri getiriniz.
    Movie findByKullanici(List<Kullanici> kullanici);
}
