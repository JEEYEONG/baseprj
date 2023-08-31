package kr.co.baseprj.controller.advice;

import javax.servlet.http.HttpServletRequest;
import kr.co.baseprj.exception.ErrorResult;
import kr.co.baseprj.exception.NotEmptyException;
import kr.co.baseprj.exception.PasswordMisMatchException;
import kr.co.baseprj.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class LoginControllerAdvice {
  @ExceptionHandler(NotEmptyException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ErrorResult> methodValidException(NotEmptyException e, HttpServletRequest request){
    ErrorResult errorResult = new ErrorResult("NotEmpty", e.getMessage());
    return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler(PasswordMisMatchException.class)
  @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
  public ResponseEntity<ErrorResult> methodValidException(PasswordMisMatchException e, HttpServletRequest request){
    ErrorResult errorResult = new ErrorResult("PasswordMismatch", e.getMessage());
    return new ResponseEntity<>(errorResult, HttpStatus.NOT_ACCEPTABLE);
  }
  @ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ErrorResult> methodValidException(UserNotFoundException e, HttpServletRequest request){
    ErrorResult errorResult = new ErrorResult("UserNotFound", e.getMessage());
    return new ResponseEntity<>(errorResult, HttpStatus.NOT_FOUND);
  }
}
