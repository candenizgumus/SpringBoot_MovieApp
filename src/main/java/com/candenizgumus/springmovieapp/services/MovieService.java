package com.candenizgumus.springmovieapp.services;

import com.candenizgumus.springmovieapp.dto.request.MovieCommentSaveDto;
import com.candenizgumus.springmovieapp.dto.request.MovieSaveDto;
import com.candenizgumus.springmovieapp.dto.response.MovieFindAllDto;
import com.candenizgumus.springmovieapp.entities.Genre;
import com.candenizgumus.springmovieapp.entities.Kullanici;
import com.candenizgumus.springmovieapp.entities.Movie;
import com.candenizgumus.springmovieapp.entities.MovieComment;
import com.candenizgumus.springmovieapp.mappers.MovieMapper;
import com.candenizgumus.springmovieapp.repositories.MovieRepository;
import com.candenizgumus.springmovieapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService extends ServiceManager<Movie,Long>
{
    private final MovieRepository movieRepository;
    private final KullaniciService kullaniciService;
    private final MovieCommentService movieCommentService;
    private final GenreService genreService;

    public MovieService(MovieRepository movieRepository, KullaniciService kullaniciService, MovieCommentService movieCommentService, GenreService genreService)
    {
        super(movieRepository);
        this.movieRepository = movieRepository;
        this.kullaniciService = kullaniciService;
        this.movieCommentService = movieCommentService;
        this.genreService = genreService;
    }

    @Override
    public Movie save(Movie movie)
    {
      /*  Optional<Kullanici> eklenecekKullanici = kullaniciService.findById(movie.getKullanici().getFirst().getId());
        Optional<MovieComment> eklenecekMovieComment = movieCommentService.findById(movie.getMoviecomment().getFirst().getId());
        Optional<Genre> eklenecekGenre = genreService.findById(movie.getGenre().getFirst().getId());
        movie.getKullanici().add(eklenecekKullanici.get());
        movie.getMoviecomment().add(eklenecekMovieComment.get());
        movie.getGenre().add(eklenecekGenre.get());*/
        return super.save(movie);
    }

    public Movie saveDto(MovieSaveDto dto)
    {
        return movieRepository.save(MovieMapper.INSTANCE.movieSaveDtoToMovie(dto));
    }

    public Movie turEkle(Long genreId, Long filmId)
    {
        Optional<Movie> updateEdilecekFilm = findById(filmId);
        Optional<Genre> eklenecekGenre = genreService.findById(genreId);
        List<Genre> varOlanList = updateEdilecekFilm.get().getGenre();
        varOlanList.add(eklenecekGenre.get());
        updateEdilecekFilm.get().setGenre(varOlanList);

        return movieRepository.save(updateEdilecekFilm.get());
    }

    public List<MovieFindAllDto> findAllDto()
    {
        List<Movie> movies = movieRepository.findAll();
        List<MovieFindAllDto> movieFindAllDtoList = new ArrayList<>();
        for (Movie movie : movies)
        {
           movieFindAllDtoList.add( MovieMapper.INSTANCE.movieFindAllDtoToMovie(movie));
        }
        return movieFindAllDtoList;
    }
}
