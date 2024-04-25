package com.candenizgumus.services;

import com.candenizgumus.entities.Kullanici;
import com.candenizgumus.entities.MovieComment;
import com.candenizgumus.repositories.KullaniciRepository;
import com.candenizgumus.repositories.MovieCommentRepository;
import com.candenizgumus.utility.ServiceManager;
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
