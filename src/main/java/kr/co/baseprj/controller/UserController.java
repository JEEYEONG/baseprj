package kr.co.baseprj.controller;

import java.util.List;
import kr.co.baseprj.paging.PageHandler;
import kr.co.baseprj.paging.SearchCondition;
import kr.co.baseprj.service.UserService;
import kr.co.baseprj.vo.user.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

  private final UserService userService;

  //  회원등록페이지 이동
  @GetMapping("/signUp")
  public String signUp() {
    return "user/userForm";
  }

  @PostMapping("/signUp")
  public String signUp(UserVo userVo,
      @SessionAttribute(name = "currentUser", required = false) String currentUser,
      Model model) {
    if (userService.validate(userVo)) {
    }

    System.out.println("+++++++++" + userService.validate(userVo));
    try {
      userService.joinUser(userVo, currentUser);
    } catch (IllegalAccessError e) {
      model.addAttribute("errorMessage", "등록 중 에러가 발생하였습니다.");
      return "user/userForm";

    }
    return "redirect:/";
  }

  @ResponseBody
  @PostMapping ("/idCheck")
  public String idCheck(@RequestBody UserVo userVo) {
    String checkId = "N";
    int result = userService.checkId(userVo.getUserId());
    if (result == 1) {
      checkId = "Y"; //아이디가 있으면 Y
    }
    return checkId;
  }

  //  회원목록
  @GetMapping("/userList")
  public String userList(Model model, SearchCondition sc) {
    int totalCnt = userService.getResultCnt();
    PageHandler ph = new PageHandler(totalCnt, sc);

    List<UserVo> userLists = userService.userList(sc);

    model.addAttribute("userLists", userLists);
    model.addAttribute("page", ph);
    return "user/userList";
  }

  //  회원 상세보기
  @GetMapping(value = {"/userDetail/{userId}", "/userDetail"})
  public String userDetail(Model model, @PathVariable("userId") String userId) {
    UserVo userVo = userService.getUserDtl(userId);
    model.addAttribute("userDtl", userVo);

    return "user/userDetail";
  }

  // 회원 삭제 근데 db는 남아있는
  @GetMapping("/delete/{userId}")
  public String deleteUser(@PathVariable("userId") String userId, Model model, SearchCondition sc) {
    userService.userDelete(userId);
    List<UserVo> userLists = userService.userList(sc);
    model.addAttribute("userLists", userLists);

    return "user/userList";
  }

  // 회원 수정 페이지 이동
  @GetMapping("/mod/{userId}")
  public String modUser(@PathVariable("userId") String userId, Model model) {
    UserVo userVo = userService.getUserDtl(userId);
    model.addAttribute("userDtl", userVo);

    return "user/userMod";
  }

  // 수정 버튼 클릭시 작동
  @PostMapping("/mod/{userId}")
  public String modUser(UserVo userVo, Model model, SearchCondition sc, @SessionAttribute(name = "currentUser", required = false) String currentUser) {
    userService.updateUser(userVo,currentUser);
    List<UserVo> userLists = userService.userList(sc);

    int totalCnt = userService.getResultCnt();
    PageHandler ph = new PageHandler(totalCnt, sc);

    model.addAttribute("userLists", userLists);
    model.addAttribute("page", ph);
    return "user/userList";
  }

}
