package kr.co.baseprj.controller;

import java.util.List;
import kr.co.baseprj.service.AuthMenuService;
import kr.co.baseprj.vo.authMenu.AuthMenuVo;
import kr.co.baseprj.vo.menu.MenuSaveVo;
import kr.co.baseprj.vo.menu.MenuVo;
import kr.co.baseprj.vo.user.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/authMenu")
public class AuthMenuController {

  private final AuthMenuService authMenuService;


  @GetMapping("/list")
  public String menuList(Model model){
    List<MenuVo> menuList = authMenuService.menuList();
    List<UserVo> userList = authMenuService.userList();


    model.addAttribute("menuList", menuList);
    model.addAttribute("userList", userList);

    return "menu/menuList";
  }


  @GetMapping("/save")
  public String saveMenu() {
    return "menu/menuList/";
  }

  @PostMapping("/save")
  public String saveMenu(AuthMenuVo authMenuVo, Model model) {
    authMenuService.save(authMenuVo);

    return "redirect:/";

  }
}
