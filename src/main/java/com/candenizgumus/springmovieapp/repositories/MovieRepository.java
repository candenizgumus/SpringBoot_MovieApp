package com.candenizgumus.springmovieapp.repositories;

import com.candenizgumus.springmovieapp.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>
{

}
