package kr.co.baseprj.controller.advice;

import kr.co.baseprj.exception.MenuExceptionResponse;
import kr.co.baseprj.exception.MenuSaveVoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MenuControllerAdvice {

  @ExceptionHandler(MenuSaveVoException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<MenuExceptionResponse> methodValidException(MenuSaveVoException e) {
    MenuExceptionResponse menuExceptionResponse = new MenuExceptionResponse(e.getExceptionCode());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(menuExceptionResponse);
  }
}
