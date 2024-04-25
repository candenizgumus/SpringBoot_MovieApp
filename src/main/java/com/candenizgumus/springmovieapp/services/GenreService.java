package com.candenizgumus.springmovieapp.services;

import com.candenizgumus.springmovieapp.dto.request.GenreSaveDto;
import com.candenizgumus.springmovieapp.entities.Genre;
import com.candenizgumus.springmovieapp.mappers.GenreMapper;
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

    public Genre saveDto(GenreSaveDto dto)
    {
        return genreRepository.save(GenreMapper.INSTANCE.genreSaveDtoToGenre(dto));
    }
}
