package com.candenizgumus.repositories;

import com.candenizgumus.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long>
{
}
