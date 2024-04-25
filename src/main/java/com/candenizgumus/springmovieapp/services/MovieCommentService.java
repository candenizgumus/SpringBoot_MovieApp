package com.candenizgumus.springmovieapp.services;

import com.candenizgumus.springmovieapp.entities.MovieComment;
import com.candenizgumus.springmovieapp.repositories.MovieCommentRepository;
import com.candenizgumus.springmovieapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class MovieCommentService extends ServiceManager<MovieComment,Long>
{
    private final MovieCommentRepository movieCommentRepository;

    public MovieCommentService(MovieCommentRepository movieCommentRepository)
    {
        super(movieCommentRepository);
        this.movieCommentRepository = movieCommentRepository;
    }
}
