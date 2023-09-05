package kr.co.baseprj.controller.advice;

import kr.co.baseprj.exception.AlreadyExistException;
import kr.co.baseprj.exception.ErrorResult;
import kr.co.baseprj.exception.NotEmptyException;
import kr.co.baseprj.exception.PasswordMisMatchException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class CodeControllerAdvice {
  @ExceptionHandler(AlreadyExistException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ErrorResult> methodValidException(AlreadyExistException e, HttpServletRequest request){
    ErrorResult errorResult = new ErrorResult("AlreadyExist", e.getMessage());
    return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
  }

    @ExceptionHandler(NotEmptyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResult> methodValidException(NotEmptyException e, HttpServletRequest request){
        ErrorResult errorResult = new ErrorResult("Empty", e.getMessage());
        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }
}
