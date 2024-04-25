package com.candenizgumus.springmovieapp.dto.request;



import java.time.LocalDate;


public record KullaniciSaveDto(String name, String surname, String email, String phone, String password)
{
}
