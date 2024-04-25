package com.candenizgumus.controllers;

import static com.candenizgumus.constants.EndPoints.*;

import com.candenizgumus.entities.Genre;
import com.candenizgumus.services.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(GENRE)
@RequiredArgsConstructor
public class GenreController
{
    private final GenreService genreService;

    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<Genre> save(@RequestBody Genre genre)
    {
        return ResponseEntity.ok( genreService.save(genre));
    }

    @GetMapping(FINDALL)
    @CrossOrigin("*")
    public ResponseEntity<List<Genre>> findAll()
    {
        return ResponseEntity.ok(genreService.findAll());
    }


}
