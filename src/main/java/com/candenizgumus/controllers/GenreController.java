package com.candenizgumus.controllers;

import static com.candenizgumus.constants.EndPoints.*;
import com.candenizgumus.services.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GENRE)
@RequiredArgsConstructor
public class GenreController
{
    private final GenreService genreService;

}
