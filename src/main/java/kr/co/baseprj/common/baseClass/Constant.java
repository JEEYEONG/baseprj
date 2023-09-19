package kr.co.baseprj.common.baseClass;

/**
 * 애플리케이션에서 사용되는 상수들을 정의한 클래스입니다.
 */
public class Constant {

  /* 결과, 오류 코드 */
  public static final String SUCCESS_CODE = "0000";

  public static final String BINDING_ERRPR_CODE = "1000";

  public static final String DUPLICATION_CODE = "2000";

  public static final String TRANSACTION_FAIL = "9000";

  public static final String SYSTEM_ERROR_CODE = "9999";

  /* 결과 메세지   */

  public static final String SUCCESS_CODE_MSG = "정상 처리 되었습니다.";

  public static final String BINDING_ERRPR_CODE_MSG = "";

  public static final String DUPLICATION_CODE_MSG = "중복된 데이터가 있습니다.";

  public static final String TRANSACTION_FAIL_MSG = "저장이 정상적으로 이뤄지지 않았습니다.";

  public static final String SYSTEM_ERROR_CODE_MSG = "알 수 없는 시스템 오류입니다.";

  /* 세션에 집어넣을 밸류 명*/
  public static final String SESSION_USER_ID = "userId";

  public static final String SESSION_USER_NM = "userNm";

  public static final String SESSION_AUTH_GROUP_CD = "authGroupCd";

  public static final String SESSION_USER_DIV = "userDiv";

  public static final String SESSION_USER_VO = "userVo";

}