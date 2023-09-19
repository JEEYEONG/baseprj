package kr.co.baseprj.common.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import kr.co.baseprj.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;


public class BaseController {

  private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

  @Autowired(required = true)
  private HttpServletRequest request;

  @Value("${page.rowsPerPage}")
  private int defaultRowsPerPage;

  @Value("${spring.profiles.active}")
  private String severMod;

  /**
   *
   * @param result
   * @return
   */
  public static String getErrMsgValidAnnotation(BindingResult result) {
    StringBuilder message = new StringBuilder("");
    HashMap<String, String> map = new HashMap<>();

    // Validation 오류 발생시
    if (result.hasErrors()) {
      List<FieldError> errors = result.getFieldErrors();
      int errSize = errors.size();
      for (int i = 0; i < errSize; i++) {
        if (map.containsKey(errors.get(i).getField())) {
          map.put(errors.get(i).getField(),
              map.get(errors.get(i).getField()) + " " + errors.get(i).getDefaultMessage());
        } else {
          map.put(errors.get(i).getField(), errors.get(i).getDefaultMessage());
        }
      }
    }

    List<String> valueList = new ArrayList<>(map.values());
    for (Map.Entry<String, String> pair : map.entrySet()) {
      message.append(pair.getValue() + "\n");
    }

    return message.toString();
  }

  public HttpServletRequest getRequest() {
    return request;
  }

  public String getUserId() {
    return "tempId";
  }

  /**
   * PageNavigator Setting
   *
   * @return
   */
  protected PageNavigator makePageNavigator() {
    logger.debug("[공통 컨트롤러] 페이징 데이터 처리 시작");
    // current page setter
    int currentPage = 1;
    if (!StringUtils.isEmpty(request.getParameter("currentPage")) && StringUtils.isNumeric(
        request.getParameter("currentPage"))) {
      currentPage = Integer.parseInt(request.getParameter("currentPage"));
    }

    // list size setter
    int rowsPerPage = defaultRowsPerPage;
    if (!StringUtils.isEmpty(request.getParameter("rowsPerPage")) && StringUtils.isNumeric(
        request.getParameter("rowsPerPage"))) {
      rowsPerPage = Integer.parseInt(request.getParameter("rowsPerPage"));
    }

    if (rowsPerPage < 0) {
      rowsPerPage = defaultRowsPerPage;
    }

    PageNavigator pageNavi = new PageNavigator(currentPage, rowsPerPage);
    logger.debug("[공통 컨트롤러] 페이징 데이터 : " + pageNavi.toString());

    return pageNavi;
  }
/*

  */
/**
   * 로컬 개발시 userID 셋팅
   *
   * @throws Exception
   *//*

  protected void userSessCheck() throws Exception {
    logger.debug("serverMode : {}", severMod);

    if ("local".equals(severMod)) {
      UserSessUtil.getNewSess(request);
      UserSessUtil.setMngrId(request, "testUser");
    }
  }
*/

}
