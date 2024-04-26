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
import com.candenizgumus.springmovieapp.util.DataImpl;
import com.candenizgumus.springmovieapp.util.data.Root;
import com.candenizgumus.springmovieapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService extends ServiceManager<Movie,Long>
{
    private final MovieRepository movieRepository;

    private final GenreService genreService;

    public MovieService(MovieRepository movieRepository, GenreService genreService)
    {
        super(movieRepository);
        this.movieRepository = movieRepository;

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

    public void addMoviesToDatabaseFromAPI(){ //TODO tür varsa yeni tür yaratmasın bunu nasıl engelelyecez
        DataImpl data = new DataImpl();
        Root[] movies = data.saveMoviesFromTvMaze();



        for (Root movie : movies)
        {
            List<Genre> genreList = new ArrayList<>();

            for (String genre : movie.genres)
            {
                genreList.add(Genre.builder().name(genre).build());
            }
            movieRepository.save(
                    Movie.builder()

                            .language(movie.language)
                            .image(movie.image.medium)
                            .name(movie.name)
                            .country(movie.network != null ? movie.network.country.name : "Bilinmiyor")
                            .rating(movie.rating.average)
                            .summary(movie.summary)
                            .premiered(LocalDate.parse(movie.premiered)) //burada hata olabilir
                            .url(movie.url)
                            .genre(genreList)
                            .build()
            );
        }
    }
}
