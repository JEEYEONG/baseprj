package kr.co.baseprj.exception;

public class PasswordMisMatchException extends RuntimeException {

  public PasswordMisMatchException(String message) {
    super(message);
  }
}
