package com.candenizgumus.springmovieapp.mappers;


import com.candenizgumus.springmovieapp.dto.request.GenreSaveDto;
import com.candenizgumus.springmovieapp.dto.request.KullaniciRegisterDto;
import com.candenizgumus.springmovieapp.dto.request.KullaniciSaveDto;
import com.candenizgumus.springmovieapp.dto.response.KullaniciLoginResponseDto;
import com.candenizgumus.springmovieapp.dto.response.KullaniciRegisterResponseDto;
import com.candenizgumus.springmovieapp.entities.Genre;
import com.candenizgumus.springmovieapp.entities.Kullanici;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KullaniciMapper
{
    KullaniciMapper INSTANCE = Mappers.getMapper( KullaniciMapper.class );

    Kullanici kullaniciSaveDtoToKullanici(KullaniciSaveDto dto);
    Kullanici kullaniciRegisterDto(KullaniciRegisterDto dto);
    KullaniciRegisterResponseDto kullaniciToResponseDto(Kullanici kullanici);
    KullaniciLoginResponseDto kullaniciToResponseid(Kullanici kullanici);




}
