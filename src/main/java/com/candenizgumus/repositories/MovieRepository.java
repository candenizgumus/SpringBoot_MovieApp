package com.candenizgumus.repositories;

import com.candenizgumus.entities.Kullanici;
import com.candenizgumus.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long>
{
}
