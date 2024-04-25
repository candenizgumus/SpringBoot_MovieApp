package com.candenizgumus.springmovieapp.dto.request;



import java.time.LocalDate;


public record MovieSaveDto (String language, String image, String name, String country, Integer rating,String summary,
                           LocalDate premired, String url)
{
}
