package kr.co.baseprj.service;

import java.util.Objects;
import java.util.Optional;
import kr.co.baseprj.exception.NotEmptyException;
import kr.co.baseprj.exception.PasswordMisMatchException;
import kr.co.baseprj.exception.UserNotFoundException;
import kr.co.baseprj.mapper.UserMapper;
import kr.co.baseprj.vo.user.LoginFormVo;
import kr.co.baseprj.vo.user.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

  private final UserMapper userMapper;

  @Override
  public boolean validateLogin(LoginFormVo loginForm) {

    if (!StringUtils.hasText(loginForm.getUserId()) || !StringUtils.hasText(
        loginForm.getSecretNum())) {
      throw new NotEmptyException("아이디, 비밀번호를 입력해주세요.");
    }

    Optional<UserVo> findUser = userMapper.findUserById(loginForm.getUserId());
    findUser.orElseThrow(() -> new UserNotFoundException("존재하지 않는 아이디 입니다."));

    String password = findUser.get().getUserNm();
    log.info("password={}", password);
    if (!Objects.equals(password, loginForm.getSecretNum())) {
      throw new PasswordMisMatchException("패스워드가 일치하지 않습니다.");
    }

    return true;
  }
}
