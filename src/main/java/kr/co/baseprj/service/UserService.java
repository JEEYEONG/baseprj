package kr.co.baseprj.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import kr.co.baseprj.common.CommonWord;
import kr.co.baseprj.mapper.UserMapper;
import kr.co.baseprj.vo.user.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
  Date time = new Date();
  String localTime = format.format(time);
  @Autowired
  private UserMapper userMapper;

  public void joinUser(UserVo userVo, String currentUser) {
    /*UserVo uservo = userVo.builder()
        .userId(userVo.getUserId())
        .build();*/

    userVo.setUserId(userVo.getUserId());
    userVo.setUserNm(userVo.getUserNm());
    userVo.setAuthGroupCd(userVo.getAuthGroupCd());
    userVo.setSecretNum(userVo.getSecretNum());
    userVo.setRegDt(LocalDateTime.now());
    userVo.setModDt(null);
    userVo.setRegrId(currentUser);
    userVo.setModrId(userVo.getModrId());
    userVo.setDelYn(CommonWord.DEL_N);
    userVo.setUserDiv(userVo.getUserDiv());

    userMapper.saveUser(userVo);
  }

  public List<UserVo> userList() {
    return userMapper.getUserList();
  }

  public UserVo getUserDtl(String userId) {
    Optional<UserVo> findUser = userMapper.findByUserId(userId);
    UserVo userVo = findUser.get();
    return userVo;
  }
}
