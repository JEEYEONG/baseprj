package kr.co.baseprj.controller;

import java.util.List;
import java.util.Optional;
import kr.co.baseprj.service.UserService;
import kr.co.baseprj.vo.user.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

//  회원등록페이지 이동
  @GetMapping("/signUp")
  public String signUp() {
    return "user/userForm";
  }
//  회원등록
  @PostMapping("/signUp")
  public String signUp(UserVo userVo, @SessionAttribute(name = "currentUser", required = false) String currentUser) {
    userService.joinUser(userVo, currentUser);
    return "redirect:/";
  }
//  회원목록
  @GetMapping("/userList")
  public String userList(Model model) {
    List<UserVo> userLists = userService.userList();
    model.addAttribute("userLists",userLists);

    return "user/userList";
  }
//  회원 상세보기
  @GetMapping("/userDetail/{userId}")
  public String userDetail(Model model, @PathVariable("userId") String userId){
    UserVo userVo =  userService.getUserDtl(userId);
    model.addAttribute("userDtl", userVo);

    return "user/userDetail";
  }


}
