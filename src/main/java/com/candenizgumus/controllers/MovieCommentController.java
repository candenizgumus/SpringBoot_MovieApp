package com.candenizgumus.controllers;

import com.candenizgumus.services.MovieCommentService;
import com.candenizgumus.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moviecomment")
@RequiredArgsConstructor
public class MovieCommentController
{
    private final MovieCommentService movieCommentService;

}
