package com.candenizgumus.springmovieapp.services;

import com.candenizgumus.springmovieapp.dto.request.MovieCommentSaveDto;
import com.candenizgumus.springmovieapp.entities.MovieComment;
import com.candenizgumus.springmovieapp.mappers.MovieCommentMapper;
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

    public MovieComment saveDto(MovieCommentSaveDto dto)
    {
        return movieCommentRepository.save(MovieCommentMapper.INSTANCE.movieCommentSaveDtoToMovieComment(dto));
    }
}
