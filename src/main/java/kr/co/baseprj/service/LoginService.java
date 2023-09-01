package kr.co.baseprj.service;

import kr.co.baseprj.vo.user.LoginFormVo;

public interface LoginService {

  boolean validateLogin(LoginFormVo loginForm);
}
