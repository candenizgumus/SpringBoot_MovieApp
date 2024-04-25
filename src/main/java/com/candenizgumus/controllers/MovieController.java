package com.candenizgumus.controllers;

import com.candenizgumus.entities.Movie;
import com.candenizgumus.entities.MovieComment;
import com.candenizgumus.services.MovieService;
import static com.candenizgumus.constants.EndPoints.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(MOVIE)
@RequiredArgsConstructor
public class MovieController
{
    private final MovieService movieService;


    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<Movie> save(@RequestBody Movie movie)
    {
        return ResponseEntity.ok( movieService.save(movie));
    }

    @GetMapping(FINDALL)
    @CrossOrigin("*")
    public ResponseEntity<List<Movie>> findAll()
    {
        return ResponseEntity.ok(movieService.findAll());
    }
}
