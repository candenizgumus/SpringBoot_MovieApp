package com.candenizgumus.springmovieapp.services;

import com.candenizgumus.springmovieapp.dto.request.MovieSaveDto;
import com.candenizgumus.springmovieapp.dto.response.MovieFindAllDto;
import com.candenizgumus.springmovieapp.dto.response.MovieFindByRatingAndCountDto;
import com.candenizgumus.springmovieapp.entities.Genre;
import com.candenizgumus.springmovieapp.entities.Kullanici;
import com.candenizgumus.springmovieapp.entities.Movie;
import com.candenizgumus.springmovieapp.entities.MovieComment;
import com.candenizgumus.springmovieapp.exceptions.MovieAppException;
import com.candenizgumus.springmovieapp.exceptions.ErrorType;
import com.candenizgumus.springmovieapp.mappers.MovieMapper;
import com.candenizgumus.springmovieapp.repositories.MovieRepository;
import com.candenizgumus.springmovieapp.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService extends ServiceManager<Movie, Long>
{
    private final MovieRepository movieRepository;
    private final KullaniciService kullaniciService;
    private final GenreService genreService;

    public MovieService(MovieRepository movieRepository, KullaniciService kullaniciService, GenreService genreService)
    {
        super(movieRepository);
        this.movieRepository = movieRepository;
        this.kullaniciService = kullaniciService;

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
            movieFindAllDtoList.add(MovieMapper.INSTANCE.movieFindAllDtoToMovie(movie));
        }
        return movieFindAllDtoList;
    }

    public List<Movie> findAllById(List<Long> ids)
    {
        return ids.stream().map(id -> findById(id).orElseThrow(() -> new MovieAppException(ErrorType.MOVIE_NOT_FOUND))).collect(Collectors.toList());

    }

    public List<Movie> findAllByRatingGreaterThan(double value)
    {
        return movieRepository.findAllByRatingGreaterThan(value);

    }

    public List<MovieFindAllDto> findByGenre(Long kullaniciId)
    {
        Kullanici kullanici = kullaniciService.findById(kullaniciId).orElseThrow(() -> new MovieAppException(ErrorType.KULLANICI_NOT_FOUND));
        List<Genre> favgenreList = kullanici.getFavgenre();
        List<Movie> allMovies = movieRepository.findAll();
        List<MovieFindAllDto> newMovieList = new ArrayList<>();
        for (Genre genre : favgenreList)
        {
            for (Movie allMovie : allMovies)
            {
                for (Genre genre1 : allMovie.getGenre())
                {
                    if (genre.getName().equals(genre1.getName()))
                    {
                        MovieFindAllDto movieFindAllDto = MovieMapper.INSTANCE.movieFindAllDtoToMovie(allMovie);
                        newMovieList.add(movieFindAllDto);
                    }
                }
            }
        }

        return newMovieList;

    }

    public List<Movie> findAllByPremieredBefore(LocalDate tarih)
    {
        return movieRepository.findAllByPremieredBefore(tarih);
    }

    public List<MovieFindByRatingAndCountDto> findByRatingAndCount(double rating)
    {
        List<Object[]> movies = movieRepository.findByRatingAndCount(rating);
        List<MovieFindByRatingAndCountDto> movieFindByRatingAndCountDtoList = new ArrayList<>();
        for (Object[] movie : movies)
        {
            Number movieRating = (Number) movie[1];
            Number movieCount = (Number) movie[0];
            MovieFindByRatingAndCountDto movieFindByRatingAndCountDto = new MovieFindByRatingAndCountDto(movieCount.longValue(), movieRating.doubleValue());
            movieFindByRatingAndCountDtoList.add(movieFindByRatingAndCountDto);
        }
        return movieFindByRatingAndCountDtoList;
    }

    public Long countByRating(double rating)
    {
        return movieRepository.countByRating(rating);
    }

    public List<List<Movie>> findAllByName(List<String> movieNames)
    {
        List<List<Movie>> movieList = new ArrayList<>();
        for (String movieName : movieNames)
        {
            List<Movie> allByName = movieRepository.findAllByName(movieName);
            if (!allByName.isEmpty())
            {
                movieList.add(allByName);
            }
        }
        return movieList;
    }

    public List<Object> findMoviesByCountry(){
        return movieRepository.findMoviesByCountry();
    }




}
