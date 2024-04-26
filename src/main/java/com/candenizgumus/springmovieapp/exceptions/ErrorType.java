package com.candenizgumus.springmovieapp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType
{
  MOVIE_NOT_FOUND(5001,"Böyle bir Movie bulunamadı", HttpStatus.NOT_FOUND),
  KULLANICI_NOT_FOUND(5002,"Böyle bir Kullanici bulunamadı", HttpStatus.NOT_FOUND),
  PASSWORDS_ARE_NOT_SAME(5003,"Sifreler ayni degil", HttpStatus.NOT_FOUND),
  EMAIL_TAKEN(5004,"Email daha önce alınmis", HttpStatus.NOT_FOUND);


  private Integer code;
  private String message;
  private HttpStatus status;
}
