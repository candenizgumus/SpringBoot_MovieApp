package com.candenizgumus.springmovieapp.services;

import com.candenizgumus.springmovieapp.dto.request.MovieCommentSaveDto;
import com.candenizgumus.springmovieapp.entities.MovieComment;
import com.candenizgumus.springmovieapp.mappers.MovieCommentMapper;
import com.candenizgumus.springmovieapp.repositories.MovieCommentRepository;
import com.candenizgumus.springmovieapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    public List<MovieComment> findAllByMovie_Id(Long movieId){
        return movieCommentRepository.findAllByMovie_Id(movieId);
    }

    public List<MovieComment> findAllByMovie_IdAndDateBetween(Long movieId, LocalDate start, LocalDate finish){
    return movieCommentRepository.findAllByMovie_IdAndDateBetween(movieId,start,finish);
    }

    public List<MovieComment> findAllByContentGreaterThan(int adet){
        return movieCommentRepository.findAllByContentGreaterThan(adet);
    }
}
