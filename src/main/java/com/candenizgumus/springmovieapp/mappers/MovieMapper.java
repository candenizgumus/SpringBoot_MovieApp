package com.candenizgumus.springmovieapp.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieMapper
{
    MovieMapper INSTANCE = Mappers.getMapper( MovieMapper.class );




}
