package com.candenizgumus.springmovieapp.controllers;

import com.candenizgumus.springmovieapp.dto.request.MovieCommentSaveDto;
import com.candenizgumus.springmovieapp.entities.MovieComment;
import com.candenizgumus.springmovieapp.services.MovieCommentService;
import com.candenizgumus.springmovieapp.constants.EndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EndPoints.MOVIECOMMENT)
@RequiredArgsConstructor
public class MovieCommentController
{
    private final MovieCommentService movieCommentService;

    @PostMapping(EndPoints.SAVEDTO)
    @CrossOrigin("*")
    public ResponseEntity<MovieComment> saveDto(@RequestBody MovieCommentSaveDto dto)
    {
        return ResponseEntity.ok( movieCommentService.saveDto(dto));
    }
    @PostMapping(EndPoints.SAVE)
    @CrossOrigin("*")
    public ResponseEntity<MovieComment> save(@RequestBody MovieComment movieComment)
    {
        return ResponseEntity.ok( movieCommentService.save(movieComment));
    }
    @GetMapping(EndPoints.FINDALL)
    @CrossOrigin("*")
    public ResponseEntity<List<MovieComment>> findAll()
    {
        return ResponseEntity.ok(movieCommentService.findAll());
    }
}
