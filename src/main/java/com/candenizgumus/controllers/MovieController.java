package com.candenizgumus.controllers;

import com.candenizgumus.services.MovieService;
import static com.candenizgumus.constants.EndPoints.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MOVIE)
@RequiredArgsConstructor
public class MovieController
{
    private final MovieService movieService;

}
