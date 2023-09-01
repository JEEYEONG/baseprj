package kr.co.baseprj.exception;

public class NotEmptyException extends RuntimeException{

  public NotEmptyException(String message) {
    super(message);
  }
}
