package kr.co.baseprj.controller;

import java.util.List;
import kr.co.baseprj.service.MenuService;
import kr.co.baseprj.vo.menu.MenuSaveVo;
import kr.co.baseprj.vo.menu.MenuVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@Slf4j
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

  private final MenuService menuService;

  @GetMapping("/save/{menuCd}")
  public String menuForm(Model model) {
    List<MenuVo> menuList = menuService.getMenuList();
    model.addAttribute("menuList", menuList);
    return "menu/menu";
  }

  @PostMapping("/save/{menuCd}")
  @ResponseBody
  public String saveMenu(@PathVariable("menuCd") String menuCd,
      @RequestBody MenuSaveVo menuSaveVo) {
    if (menuService.isValidate(menuSaveVo)) {

    }
    return null;
  }

  @GetMapping("/menuList")
  public String menuList(Model model) {

    return "menu/menuList";
  }
}
