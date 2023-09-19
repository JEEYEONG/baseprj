package kr.co.baseprj.common.interceptor;


import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.baseprj.common.utils.UserSessUtil;
import kr.co.baseprj.mgmt.userMgmt.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Slf4j
@Component
@RequiredArgsConstructor
public class HttpInterceptor extends HandlerInterceptorAdapter {

  /*private final MenuDao menuDao;*/

  /**
   * HTTP 요청 전에 실행되는 메서드입니다.
   * 로그인 여부를 확인하고 로그인되지 않은 경우 로그인 화면으로 리다이렉트합니다.
   *
   * @param request  HttpServletRequest 객체
   * @param response HttpServletResponse 객체
   * @param handler  핸들러
   * @return 로그인 상태인 경우 true, 로그인되지 않은 경우 false
   * @throws IOException 입출력 예외
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
    String url = request.getRequestURI();
    UserVo userVo = UserSessUtil.getUserVo(request);
   /* String authGroupCd = UserSessUtil.getAuthGroupCdType(request);*/

    log.info("interceptor url : {}", url);
    log.info("interceptor userVo : {}", userVo);
    /*log.info("interceptor authGroupCd : {}", authGroupCd);*/

    String ajaxCall = (String) request.getHeader("AJAX");

    if (!UserSessUtil.isLoggedIn(request)) {
      if (ajaxCall != null) {
        response.sendError(500);
      } else {
        log.info("session 없음 ==> 로그인 화면으로 이동 ");
        response.sendRedirect(request.getContextPath() + "/system/login");
      }
      return false;
    }
    return true;
  }

  /**
   * HTTP 요청 후에 실행되는 메서드입니다.
   * ModelAndView에 추가 데이터를 설정합니다.
   *
   * @param request  HttpServletRequest 객체
   * @param response HttpServletResponse 객체
   * @param handler  핸들러
   * @param modelAndView ModelAndView 객체
   * @throws Exception 예외
   */
 /* @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    String url = request.getRequestURI();
    UserVo userVo = UserSessUtil.getMngrVO(request);
    String authGroupCd = UserSessUtil.getMngrType(request);

    log.info("interceptor url : {}", url);
    log.info("interceptor userVo : {}", userVo);
    log.info("interceptor authGroupCd : {}", authGroupCd);

    if (modelAndView == null) {
      modelAndView = new ModelAndView();
    }

    MenuVo menuVo = new MenuVo();
    menuVo.setLinkUrl(url);
    menuVo.setAuthGroupCd(authGroupCd);
    List<MenuVo> menuList = menuDao.selectMenuList(menuVo);

    if (modelAndView == null) {
      modelAndView = new ModelAndView();
    }

    modelAndView.addObject("mngrVo", userVo);
    modelAndView.addObject("menuList", menuList);
    modelAndView.addObject("url", url);
    super.postHandle(request, response, handler, modelAndView);
  }*/

  /**
   * HTTP 요청 처리가 완료된 후에 실행되는 메서드입니다.
   *
   * @param request  HttpServletRequest 객체
   * @param response HttpServletResponse 객체
   * @param handler  핸들러
   * @param ex       예외
   */
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    // 아무 작업 없음
  }
}
