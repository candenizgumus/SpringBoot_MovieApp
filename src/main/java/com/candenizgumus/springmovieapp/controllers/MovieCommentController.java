package com.candenizgumus.springmovieapp.controllers;

import com.candenizgumus.springmovieapp.dto.request.MovieCommentSaveDto;
import com.candenizgumus.springmovieapp.entities.MovieComment;
import com.candenizgumus.springmovieapp.services.MovieCommentService;
import com.candenizgumus.springmovieapp.constants.EndPoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/findmoviecommentsbymovie")
    public ResponseEntity<List<MovieComment>> findAllByMovie_Id(Long movieId){
        return ResponseEntity.ok(movieCommentService.findAllByMovie_Id(movieId));
    }

    @GetMapping("/findmoviesbydatebetween")
    public ResponseEntity<List<MovieComment>> findAllByMovie_IdAndDateBetween(Long movieId, LocalDate start, LocalDate finish){
        return ResponseEntity.ok(movieCommentService.findAllByMovie_IdAndDateBetween(movieId,start,finish));
    }

    @GetMapping("findbycontentgreaterthan")
    public ResponseEntity<List<MovieComment>> findAllByContentGreaterThan(int adet){
        return ResponseEntity.ok(movieCommentService.findAllByContentGreaterThan(adet));
    }
}
