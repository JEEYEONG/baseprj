package kr.co.baseprj.exception;

import lombok.Getter;

@Getter
public class MenuSaveVoException extends RuntimeException {
  private MenuSaveExceptionCode exceptionCode;

  public MenuSaveVoException(MenuSaveExceptionCode exceptionCode) {
  }

  public MenuSaveVoException(String message, MenuSaveExceptionCode exceptionCode) {
    super(exceptionCode.getMessage());
    this.exceptionCode = exceptionCode;
  }
}
