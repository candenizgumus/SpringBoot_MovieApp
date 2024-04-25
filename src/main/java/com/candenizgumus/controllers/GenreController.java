package com.candenizgumus.controllers;

import com.candenizgumus.services.GenreService;
import com.candenizgumus.services.MovieCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genre")
@RequiredArgsConstructor
public class GenreController
{
    private final GenreService genreService;

}
