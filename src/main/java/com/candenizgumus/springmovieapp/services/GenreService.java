package com.candenizgumus.springmovieapp.services;

import com.candenizgumus.springmovieapp.dto.request.GenreSaveDto;
import com.candenizgumus.springmovieapp.entities.Genre;
import com.candenizgumus.springmovieapp.mappers.GenreMapper;
import com.candenizgumus.springmovieapp.repositories.GenreRepository;
import com.candenizgumus.springmovieapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<Genre> saveGenreString(List<String> genres){
        List<Genre> genreList = new ArrayList<>();
        for (String genre : genres)
        {
            Optional<Genre> optionalGenre = genreRepository.findByName(genre);
            //Eğer optionalGenre dolu ise, yani database'de var ise ?
            if (optionalGenre.isPresent()){
                genreList.add(optionalGenre.get());
            }else
            {
                Genre yeniGelenGenre = Genre.builder().name(genre).build();
                genreRepository.save(yeniGelenGenre);
                genreList.add(yeniGelenGenre);
            }
        }

        return genreList;
    }
}
