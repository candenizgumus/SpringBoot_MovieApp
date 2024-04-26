package com.candenizgumus.springmovieapp.repositories;

import com.candenizgumus.springmovieapp.entities.Genre;
import org.mapstruct.ap.internal.gem.GemGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long>
{
    Optional<Genre> findByName(String name);
}
