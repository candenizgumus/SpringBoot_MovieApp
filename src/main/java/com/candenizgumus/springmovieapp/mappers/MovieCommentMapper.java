package com.candenizgumus.springmovieapp.mappers;


import com.candenizgumus.springmovieapp.dto.request.MovieCommentSaveDto;
import com.candenizgumus.springmovieapp.dto.request.MovieSaveDto;
import com.candenizgumus.springmovieapp.entities.Movie;
import com.candenizgumus.springmovieapp.entities.MovieComment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieCommentMapper
{
    MovieCommentMapper INSTANCE = Mappers.getMapper( MovieCommentMapper.class );

    MovieComment movieCommentSaveDtoToMovieComment(MovieCommentSaveDto dto);


}
