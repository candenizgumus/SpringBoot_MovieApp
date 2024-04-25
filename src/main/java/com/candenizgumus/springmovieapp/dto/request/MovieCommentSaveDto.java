package com.candenizgumus.springmovieapp.dto.request;



import java.time.LocalDate;


public record MovieCommentSaveDto(String yorum, LocalDate yorumtarihi)
{
}
