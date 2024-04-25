package com.candenizgumus.springmovieapp.controllers;

import com.candenizgumus.springmovieapp.entities.Genre;
import com.candenizgumus.springmovieapp.services.GenreService;
import com.candenizgumus.springmovieapp.constants.EndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EndPoints.GENRE)
@RequiredArgsConstructor
public class GenreController
{
    private final GenreService genreService;

    @PostMapping(EndPoints.SAVE)
    @CrossOrigin("*")
    public ResponseEntity<Genre> save(@RequestBody Genre genre)
    {
        return ResponseEntity.ok( genreService.save(genre));
    }

    @GetMapping(EndPoints.FINDALL)
    @CrossOrigin("*")
    public ResponseEntity<List<Genre>> findAll()
    {
        return ResponseEntity.ok(genreService.findAll());
    }


}
