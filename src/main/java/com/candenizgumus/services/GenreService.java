package com.candenizgumus.services;

import com.candenizgumus.entities.Genre;
import com.candenizgumus.repositories.GenreRepository;
import com.candenizgumus.utility.ServiceManager;
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
