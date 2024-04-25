package com.candenizgumus.services;

import com.candenizgumus.entities.Movie;
import com.candenizgumus.entities.MovieComment;
import com.candenizgumus.repositories.MovieCommentRepository;
import com.candenizgumus.repositories.MovieRepository;
import com.candenizgumus.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends ServiceManager<Movie,Long>
{
    private final MovieRepository movieCommentRepository;

    public MovieService(MovieRepository movieCommentRepository)
    {
        super(movieCommentRepository);
        this.movieCommentRepository = movieCommentRepository;
    }
}
