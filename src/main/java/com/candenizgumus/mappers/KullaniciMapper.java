package com.candenizgumus.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KullaniciMapper
{
    KullaniciMapper INSTANCE = Mappers.getMapper( KullaniciMapper.class );




}
