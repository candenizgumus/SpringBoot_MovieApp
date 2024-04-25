package com.candenizgumus.controllers;

import com.candenizgumus.entities.Kullanici;
import com.candenizgumus.entities.MovieComment;
import com.candenizgumus.services.MovieCommentService;
import com.candenizgumus.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.candenizgumus.constants.EndPoints.*;
@RestController
@RequestMapping(MOVIECOMMENT)
@RequiredArgsConstructor
public class MovieCommentController
{
    private final MovieCommentService movieCommentService;

    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<MovieComment> save(@RequestBody MovieComment movieComment)
    {
        return ResponseEntity.ok( movieCommentService.save(movieComment));
    }

    @GetMapping(FINDALL)
    @CrossOrigin("*")
    public ResponseEntity<List<MovieComment>> findAll()
    {
        return ResponseEntity.ok(movieCommentService.findAll());
    }
}
