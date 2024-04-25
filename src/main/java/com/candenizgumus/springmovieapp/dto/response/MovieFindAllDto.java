package com.candenizgumus.springmovieapp.dto.response;

import com.candenizgumus.springmovieapp.entities.Genre;
import com.candenizgumus.springmovieapp.entities.Kullanici;
import com.candenizgumus.springmovieapp.entities.MovieComment;

import java.time.LocalDate;
import java.util.List;

public record MovieFindAllDto(Long id, String language, String image, String name, String country, String rating, String summary, LocalDate premiered, String url )
{
    //, List<Genre> genre, List<MovieComment> comment, List<Kullanici> kullanici //içinden silinenler
}
