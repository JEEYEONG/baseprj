/*
package kr.co.baseprj.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kr.co.baseprj.common.CommonWord;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    String requestURI = request.getRequestURI();
    HttpSession session = request.getSession(false);

    if (session == null || session.getAttribute(CommonWord.LOGIN_MEMBER) == null) {
      response.sendRedirect("/login?redirectURL=" + requestURI);
      return false;
    }
    return true;
  }
}
*/
