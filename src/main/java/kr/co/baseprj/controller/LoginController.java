package kr.co.baseprj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import kr.co.baseprj.service.LoginService;
import kr.co.baseprj.vo.user.LoginFormVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class LoginController {


  private final LoginService loginService;

  @GetMapping("/login")
  public String loginForm(Model model) {
    model.addAttribute("loginForm", new LoginFormVo());
    return "user/login";
  }

  @PostMapping("/login")
  @ResponseBody
  public String login(@RequestBody LoginFormVo loginForm, HttpServletRequest request) {
    if (loginService.validateLogin(loginForm)) {
      HttpSession session = request.getSession();
      session.setAttribute("userId", loginForm.getUserId());
      return "success";
    } else {
      return "fail";
    }
  }
}
