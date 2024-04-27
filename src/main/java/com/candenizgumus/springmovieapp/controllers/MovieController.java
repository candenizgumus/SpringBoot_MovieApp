package com.candenizgumus.springmovieapp.controllers;

import com.candenizgumus.springmovieapp.dto.request.MovieSaveDto;
import com.candenizgumus.springmovieapp.dto.response.MovieFindAllDto;
import com.candenizgumus.springmovieapp.dto.response.MovieFindByRatingAndCountDto;
import com.candenizgumus.springmovieapp.entities.Genre;
import com.candenizgumus.springmovieapp.entities.Kullanici;
import com.candenizgumus.springmovieapp.entities.Movie;
import com.candenizgumus.springmovieapp.exceptions.ErrorType;
import com.candenizgumus.springmovieapp.exceptions.MovieAppException;
import com.candenizgumus.springmovieapp.services.KullaniciService;
import com.candenizgumus.springmovieapp.services.MovieService;

import com.candenizgumus.springmovieapp.constants.EndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(EndPoints.MOVIE)
@RequiredArgsConstructor
public class MovieController
{
    private final MovieService movieService;




    @PostMapping(EndPoints.SAVEDTO)
    @CrossOrigin("*")
    public ResponseEntity<Movie> saveDto(@RequestBody MovieSaveDto dto)
    {
        return ResponseEntity.ok(movieService.saveDto(dto));
    }

    @PostMapping(EndPoints.SAVE)
    @CrossOrigin("*")
    public ResponseEntity<Movie> save(@RequestBody Movie movie)
    {
        return ResponseEntity.ok(movieService.save(movie));
    }

    @GetMapping(EndPoints.FINDALL)
    @CrossOrigin("*")
    public ResponseEntity<List<Movie>> findAll()
    {
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("moviefindalldto")
    @CrossOrigin("*")
    public ResponseEntity<List<MovieFindAllDto>> findAllDto()
    {
        return ResponseEntity.ok(movieService.findAllDto());
    }

    @PutMapping("/turekle")
    public ResponseEntity<Movie> turEkle(Long genreId, Long filmId)
    {
        return ResponseEntity.ok(movieService.turEkle(genreId, filmId));
    }

    @GetMapping("/findAllByRatingGreaterThan")
    @CrossOrigin("*")
    public ResponseEntity<List<Movie>> findAllDto(double value)
    {
        return ResponseEntity.ok(movieService.findAllByRatingGreaterThan(value));
    }

    @GetMapping("/findbygenre")
    public ResponseEntity<List<MovieFindAllDto>> findByGenre(Long kullaniciId){

        return ResponseEntity.ok(movieService.findByGenre(kullaniciId));

    }

    @GetMapping("/findallbeforetarih")
    public ResponseEntity<List<Movie>> findAllByPremieredBefore(LocalDate tarih){
        return ResponseEntity.ok(movieService.findAllByPremieredBefore(tarih));
    }

    @GetMapping("findbyratingandcount")
    public  ResponseEntity<List<MovieFindByRatingAndCountDto>> findByRatingAndCount(double rating){
        return ResponseEntity.ok(movieService.findByRatingAndCount(rating));
    }

    @GetMapping("/countbyrating")
    public ResponseEntity<Long> countByRating(double rating){
        return ResponseEntity.ok(movieService.countByRating(rating));
    }

    @GetMapping("/findmoviesbyname") //Bu metod postman ile çalışıyor
    public ResponseEntity<List<List<Movie>>> findAllByName(@RequestBody List<String> movieNames)
    {

        return ResponseEntity.ok(movieService.findAllByName(movieNames));
    }

    @GetMapping("/findmoviesbycountry")
    public ResponseEntity<List<Object>> findMoviesByCountry(){
        return ResponseEntity.ok(movieService.findMoviesByCountry());
    }
}
