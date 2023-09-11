package kr.co.baseprj.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum MenuSaveExceptionCode {
  TOP_MENU_CD_EMPTY(BAD_REQUEST, "TOP_MENU_001", "topMenuCd", "상위 카테고리를 선택해주세요."),
  TOP_MENU_NM_INVALID(BAD_REQUEST, "TOP_MENU_002", "topMenuNm", "영어 문자로만 2글자 이상 9글자 이하로 입력해야 합니다."),
  TOP_MENU_LINK_URL(BAD_REQUEST, "TOP_MENU_003", "topLinkUrl", "대표 URL은 영어 문자로 3글자 이상 10글자 이하로 입력해주세요"),
  TOP_MENU_CD_DUPLICATED(BAD_REQUEST, "TOP_MENU_004", "topMenuCd", "이미 등록된 메뉴 코드입니다."),
  SUB_MENU_NM_INVALID(BAD_REQUEST, "SUB_MENU_001", "subMenuNm", "영어 문자로 2글자 이상 9글자 이하로 입력해야 합니다."),
  SUB_MENU_LINK_URL_INVALID(BAD_REQUEST, "SUB_MENU_002", "subLinkUrl", "영어 문자로 2글자 이상 9글자 이하로 입력해야 합니다.");


  private final HttpStatus status;
  private final String code;
  private final String target;
  private final String message;



  MenuSaveExceptionCode(HttpStatus status, String code, String target, String message) {
    this.status = status;
    this.code = code;
    this.target = target;
    this.message = message;
  }

}
