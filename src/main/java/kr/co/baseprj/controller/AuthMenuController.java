package kr.co.baseprj.controller;

import java.util.List;
import kr.co.baseprj.service.AuthMenuService;
import kr.co.baseprj.service.UserService;
import kr.co.baseprj.vo.authMenu.AuthMenuVo;
import kr.co.baseprj.vo.menu.MenuVo;
import kr.co.baseprj.vo.user.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/authMenu")
public class AuthMenuController {

  private final AuthMenuService authMenuService;
  private final UserService userService;


  @GetMapping("/list")
  public String menuList(Model model) {
    List<MenuVo> menuList = authMenuService.menuList();
    List<AuthMenuVo> authMenuList = authMenuService.authMenuList();

    model.addAttribute("menuList", menuList);
    model.addAttribute("authMenuList", authMenuList);

    return "menu/menuList";
  }

  @ResponseBody
  @PostMapping("/authGroup")
  public String authGroup(@RequestBody UserVo userVo) {
    String auth = "";
    String result = userService.checkAuth(userVo.getAuthGroupCd());

    System.out.println(result);

    if (result == "root") {
      auth = "root";
    } else if (result == "admin") {
      auth = "admin";
    } else {
      auth = "user";
    }

    return auth;
  }


  @GetMapping("/save")
  public String saveMenu() {
    return "menu/menuList/";
  }

  @ResponseBody
  @PostMapping("/save")
  public String saveMenu(@RequestBody AuthMenuVo authMenuVo) {

    Integer result = authMenuService.save(authMenuVo);
    if (result != 1){
      return "fail";
    }

    return "success";

  }
}
