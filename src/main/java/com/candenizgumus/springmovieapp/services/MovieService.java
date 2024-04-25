package com.candenizgumus.springmovieapp.services;

import com.candenizgumus.springmovieapp.entities.Movie;
import com.candenizgumus.springmovieapp.repositories.MovieRepository;
import com.candenizgumus.springmovieapp.utility.ServiceManager;
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
