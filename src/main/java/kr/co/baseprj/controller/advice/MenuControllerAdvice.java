package kr.co.baseprj.controller.advice;

import javax.servlet.http.HttpServletRequest;
import kr.co.baseprj.exception.AlreadyExistException;
import kr.co.baseprj.exception.ErrorResult;
import kr.co.baseprj.exception.NotEmptyException;
import kr.co.baseprj.exception.PasswordMisMatchException;
import kr.co.baseprj.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class MenuControllerAdvice {
  @ExceptionHandler(AlreadyExistException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ErrorResult> methodValidException(PasswordMisMatchException e, HttpServletRequest request){
    ErrorResult errorResult = new ErrorResult("AlreadyExist", e.getMessage());
    return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
  }
}
