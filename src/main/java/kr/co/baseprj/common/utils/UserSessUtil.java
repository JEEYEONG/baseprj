package kr.co.baseprj.common.utils;


import static kr.co.baseprj.common.baseClass.Constant.SESSION_AUTH_GROUP_CD;
import static kr.co.baseprj.common.baseClass.Constant.SESSION_USER_ID;
import static kr.co.baseprj.common.baseClass.Constant.SESSION_USER_NM;
import static kr.co.baseprj.common.baseClass.Constant.SESSION_USER_VO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import kr.co.baseprj.mgmt.userMgmt.UserVo;


/**
 * 내부 사용자 세션 관리 유틸리티 클래스입니다. 이 클래스는 로그인 및 세션 관리와 관련된 기능을 제공합니다.
 *
 * @author sebin
 * @fileName UserSessUtil.java
 * @since 2015.10.23 -> 2023.09.15 수정
 */
public class UserSessUtil {

  public static final String IS_SYSTEM_ADMIN = "isSystemAdmin";

  private UserSessUtil() {
  }

  /**
   * 현재 사용자가 로그인 상태인지를 확인합니다.
   *
   * @param request HttpServletRequest 객체
   * @return 로그인 상태 여부 (true: 로그인 상태, false: 미로그인 상태)
   */
  public static boolean isLoggedIn(HttpServletRequest request) {
    HttpSession session = request.getSession(false);

    return session != null && session.getAttribute(SESSION_USER_VO) != null &&
        !"".equals(session.getAttribute(SESSION_USER_VO));
  }

  /**
   * 로그인 내부 사용자 Id를 저장합니다.
   *
   * @param request HttpServletRequest 객체
   * @param id      내부 사용자 Id
   */
  public static void setUserId(HttpServletRequest request, String id) {
    request.getSession(false).setAttribute(SESSION_USER_ID, id);
  }

  /**
   * 로그인 내부 사용자 이름을 저장합니다.
   *
   * @param request HttpServletRequest 객체
   * @param userNm  내부 사용자 이름
   */
  public static void setUserNm(HttpServletRequest request, String userNm) {
    request.getSession(false).setAttribute(SESSION_USER_NM, userNm);
  }

  /**
   * 로그인 권한을 저장합니다.
   *
   * @param request     HttpServletRequest 객체
   * @param authGroupCd 권한 유형
   */
  public static void setAuthGroupCd(HttpServletRequest request, String authGroupCd) {
    request.getSession(false).setAttribute(SESSION_AUTH_GROUP_CD, authGroupCd);
  }

  /**
   * 로그인 내부 사용자 VO를 저장합니다.
   *
   * @param request HttpServletRequest 객체
   * @param userVo  로그인 내부 사용자 VO
   */
  public static void setUserVo(HttpServletRequest request, UserVo userVo) {
    request.getSession(false).setAttribute(SESSION_USER_VO, userVo);
  }

  /**
   * HttpSession 객체를 만료시킵니다.
   *
   * @param request HttpServletRequest 객체
   */
  public static void invalidate(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if (session != null) {
      session.invalidate();
      session = null;
    }
  }

  /**
   * 클라이언트의 IP 주소를 가져옵니다.
   *
   * @param request HttpServletRequest 객체
   * @return 클라이언트의 IP 주소
   */
  public static String getClientIp(HttpServletRequest request) {
    String ip = request.getHeader("X-Forwarded-For");
    if (ip == null) {
      ip = request.getRemoteAddr();
    }
    return ip;
  }

  /**
   * 로그인 내부 사용자 Id를 반환합니다.
   *
   * @param request HttpServletRequest 객체
   * @return 내부 사용자 Id
   */
  public static String getUserId(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if (session != null && (String) session.getAttribute(SESSION_USER_ID) != null) {
      return (String) session.getAttribute(SESSION_USER_ID);
    } else {
      return null;
    }
  }

  /**
   * 로그인 내부 사용자 이름을 반환합니다.
   *
   * @param request HttpServletRequest 객체
   * @return 내부 사용자 이름
   */
  public static String getUserNm(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if (session != null && (String) session.getAttribute(SESSION_USER_ID) != null) {
      return (String) session.getAttribute(SESSION_USER_ID);
    } else {
      return null;
    }
  }

  /**
   * 새로운 내부 사용자 세션을 생성하고 만료 시간을 설정합니다.
   *
   * @param request HttpServletRequest 객체
   * @throws Exception 예외가 발생할 경우
   */
  public static void getNewSess(HttpServletRequest request) throws Exception {
    // 기존 세션 만료
    invalidate(request);

    // 새로운 세션 생성 및 만료 시간 설정 (30분)
    int SESS_TIMEOUT = 60 * 30;
    request.getSession(true).setMaxInactiveInterval(SESS_TIMEOUT);
  }

  /**
   * 현재 요청에서 사용자 정보를 가져옵니다.
   *
   * @param request 현재 요청을 나타내는 HttpServletRequest 객체
   * @return 사용자 정보를 포함하는 UserVo 객체, 세션에 사용자 정보가 없는 경우 null을 반환합니다.
   */
  public static UserVo getUserVo(HttpServletRequest request) {
    // 현재 세션을 가져오고 세션이 존재하며 사용자 ID가 설정되어 있는지 확인합니다.
    HttpSession session = request.getSession(false);
    if (session != null && session.getAttribute(SESSION_USER_ID) != null) {
      // 세션에서 UserVo 객체를 가져와 반환합니다.
      return (UserVo) session.getAttribute(SESSION_USER_VO);
    } else {
      // 세션 또는 사용자 정보가 없는 경우 null을 반환합니다.
      return null;
    }
  }
}
