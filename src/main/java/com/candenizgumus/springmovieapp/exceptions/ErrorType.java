package com.candenizgumus.springmovieapp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType
{
  MOVIE_NOT_FOUND(5001,"Böyle bir Movie bulunamadı", HttpStatus.NOT_FOUND),
  KULLANICI_NOT_FOUND(5002,"Böyle bir Kullanici bulunamadı", HttpStatus.NOT_FOUND);


  private Integer code;
  private String message;
  private HttpStatus status;
}
