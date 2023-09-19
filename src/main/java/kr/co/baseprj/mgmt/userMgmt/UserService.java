package kr.co.baseprj.mgmt.userMgmt;

import static kr.co.baseprj.common.baseClass.Constant.TRANSACTION_FAIL;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import kr.co.baseprj.common.base.PageNavigator;
import kr.co.baseprj.common.baseClass.Constant;
import kr.co.baseprj.common.utils.SHAUtils;
import kr.co.baseprj.common.utils.UserSessUtil;
import kr.co.baseprj.common.vo.ResultVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

  private final UserDao userDao;
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
  Date now = Timestamp.valueOf(LocalDateTime.now());

  public void insertUser(UserVo userVo) {

    userVo.setUserId(userVo.getUserId());
    userVo.setUserNm(userVo.getUserNm());
    userVo.setAuthGroupCd(userVo.getAuthGroupCd());
    userVo.setSecretNum(userVo.getSecretNum());
    userVo.setRegrId(userVo.getRegrId());
    userVo.setRegDt(now);
    userVo.setModDt(null);
    userVo.setModrId(userVo.getModrId());
    userVo.setDelYn("N");
    userVo.setUserDiv(userVo.getUserDiv());

    userDao.saveUser(userVo);
  }

  public ResultVo<HashMap<String, Object>> loginProc(UserVo param, HttpServletRequest request) {
    HashMap<String, Object> result = new HashMap<>();

    try {
      String userId = param.getUserId();

      UserVo userVo = userDao.findUserByUserId(userId);

      if (userVo != null && isPasswordValid(param.getSecretNum(), userVo.getSecretNum())) {
        UserSessUtil.getNewSess(request);
        UserSessUtil.setUserId(request, userId);
        UserSessUtil.setUserNm(request, userVo.getUserNm());
        UserSessUtil.setAuthGroupCd(request, userVo.getAuthGroupCd());
        UserSessUtil.setUserVo(request, userVo);

        result.put("resultCd", Constant.SUCCESS_CODE);
        result.put("resultMsg", "");

      } else {
        result.put("resultCd", "1001");
        result.put("resultMsg", "아이디와 비밀번호를 확인해주세요.");

      }
    } catch (SQLException se) {
      handleDatabaseError(se, result);
    } catch (Exception e) {
      handleSystemError(e, result);
    }

    return ResultVo.of("", "", result);
  }

  /**
   * 입력된 비밀번호와 저장된 비밀번호를 비교하여 유효성을 검사합니다.
   *
   * @param inputPassword  입력된 비밀번호
   * @param storedPassword 저장된 비밀번호
   * @return 비밀번호의 유효성 여부 (true: 유효, false: 무효)
   */
  private boolean isPasswordValid(String inputPassword, String storedPassword) {
    return !StringUtils.isEmpty(inputPassword) && SHAUtils.encrypt(inputPassword)
        .equals(storedPassword);
  }

  /**
   * 데이터베이스 오류를 처리하고 결과에 오류 메시지를 추가합니다.
   *
   * @param se     SQLException 객체
   * @param result 결과를 담을 HashMap 객체
   */
  private void handleDatabaseError(SQLException se, HashMap<String, Object> result) {
    se.printStackTrace();
    result.put("resultCd", TRANSACTION_FAIL);
    result.put("resultMsg", "조회시 DB 오류가 발생했습니다.");
  }

  /**
   * 시스템 오류를 처리하고 결과에 오류 메시지를 추가합니다.
   *
   * @param e      Exception 객체
   * @param result 결과를 담을 HashMap 객체
   */
  private void handleSystemError(Exception e, HashMap<String, Object> result) {
    e.printStackTrace();
    log.debug("에러가 발생했습니다:\n{}", e.getMessage());
    result.put("resultCd", "9101");
    result.put("resultMsg", "조회시 시스템 오류가 발생했습니다.");
  }

  /**
   * user 목록 조회
   *
   * @param userVo
   * @param page
   * @return
   */
  public List<UserVo> userList(UserVo userVo, PageNavigator page) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("p", page);
    paramMap.put("i", userVo);

    return userDao.userList(paramMap);
  }

  public int userListCount(UserVo userVo, PageNavigator page) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("p", page);
    paramMap.put("i", userVo);

    return userDao.userListCount(paramMap);
  }

  public List<UserVo> userLists(UserVo userVo) {
    return userDao.userLists(userVo);
  }
}
