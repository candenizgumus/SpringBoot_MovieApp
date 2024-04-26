package com.candenizgumus.springmovieapp.mappers;


import com.candenizgumus.springmovieapp.dto.request.GenreSaveDto;
import com.candenizgumus.springmovieapp.dto.request.MovieSaveDto;
import com.candenizgumus.springmovieapp.dto.response.GenreFindAllDto;
import com.candenizgumus.springmovieapp.entities.Genre;
import com.candenizgumus.springmovieapp.entities.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GenreMapper
{
    GenreMapper INSTANCE = Mappers.getMapper( GenreMapper.class );
    Genre genreSaveDtoToGenre(GenreSaveDto dto);
    GenreFindAllDto genreFindAllDtoToGenre(Genre genre);



}
