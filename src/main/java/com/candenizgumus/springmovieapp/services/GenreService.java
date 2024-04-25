package com.candenizgumus.springmovieapp.services;

import com.candenizgumus.springmovieapp.entities.Genre;
import com.candenizgumus.springmovieapp.repositories.GenreRepository;
import com.candenizgumus.springmovieapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends ServiceManager<Genre,Long>
{
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository)
    {
        super(genreRepository);
        this.genreRepository = genreRepository;
    }
}
