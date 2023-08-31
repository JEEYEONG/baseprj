package kr.co.baseprj.controller;

import java.util.List;
import kr.co.baseprj.service.UserService;
import kr.co.baseprj.vo.user.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/signUp")
  public String signUp() {
    return "user/userForm";
  }

  @PostMapping("/signUp")
  public String signUp(UserVo userVo, @SessionAttribute(name = "currentUser", required = false) String currentUser) {
    userService.joinUser(userVo, currentUser);
    return "redirect:/";
  }

  @GetMapping("/userList")
  public String userList(Model model) {
    List<UserVo> userLists = userService.userList();
    model.addAttribute(userLists);

    return "user/userList";
  }


}
