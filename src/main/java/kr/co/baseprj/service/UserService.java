package kr.co.baseprj.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import kr.co.baseprj.common.CommonWord;
import kr.co.baseprj.exception.NotEmptyException;
import kr.co.baseprj.mapper.UserMapper;
import kr.co.baseprj.paging.SearchCondition;
import kr.co.baseprj.vo.user.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
  Date time = new Date();
  String localTime = format.format(time);
  @Autowired
  private UserMapper userMapper;

  public void joinUser(UserVo userVo, String currentUser){
    /*UserVo uservo = userVo.builder()
        .userId(userVo.getUserId())
        .build();*/

//    validateDuplicateUser(userVo);

    userVo.setUserId(userVo.getUserId());
    userVo.setUserNm(userVo.getUserNm());
    userVo.setAuthGroupCd(userVo.getAuthGroupCd());
    userVo.setSecretNum(userVo.getSecretNum());
    userVo.setModDt(null);
    userVo.setModrId(userVo.getModrId());
    userVo.setDelYn(CommonWord.DEL_N);
    userVo.setUserDiv(userVo.getUserDiv());

    userMapper.saveUser(userVo);


  }

//  private void validateDuplicateUser(UserVo userVo) {
//    Optional<UserVo> findUser = userMapper.findByUserId(userVo.getUserId());
//      System.out.println(">>>>>>"+findUser);
//    if(findUser != null){
//      throw new IllegalStateException("이미 가입된 회원입니다.");
//    }
//  }

  public List<UserVo> userList(SearchCondition sc) {
    return userMapper.getUserList(sc);
  }

  public UserVo getUserDtl(String userId) {
    Optional<UserVo> findUser = userMapper.findByUserId(userId);
    UserVo userVo = findUser.get();
    return userVo;
  }

  public void userDelete(String userId) {
    userMapper.deleteUser(userId);

  }

  public void updateUser(UserVo userVo) {
    userMapper.updateUser(userVo);

  }

  public boolean validate(UserVo userVo) {
    if(!StringUtils.hasText(userVo.getUserId())) {
      log.info("회원등록 실패");
      throw new NotEmptyException("아이디를 입력해주세요");
    }
    return true;
  }

  public int getResultCnt() {
    return userMapper.findUserCnt();
  }

  public int checkId(String userId) {
    int result = userMapper.checkId(userId);
    return result;
  }
}
