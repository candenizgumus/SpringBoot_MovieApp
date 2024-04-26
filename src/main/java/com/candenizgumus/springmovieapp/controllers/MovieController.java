package com.candenizgumus.springmovieapp.controllers;

import com.candenizgumus.springmovieapp.dto.request.MovieSaveDto;
import com.candenizgumus.springmovieapp.dto.response.MovieFindAllDto;
import com.candenizgumus.springmovieapp.entities.Genre;
import com.candenizgumus.springmovieapp.entities.Movie;
import com.candenizgumus.springmovieapp.services.KullaniciService;
import com.candenizgumus.springmovieapp.services.MovieService;

import com.candenizgumus.springmovieapp.constants.EndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
