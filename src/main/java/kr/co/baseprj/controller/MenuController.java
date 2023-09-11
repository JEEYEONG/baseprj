package kr.co.baseprj.controller;

import java.util.HashMap;
import java.util.List;
import kr.co.baseprj.service.MenuService;
import kr.co.baseprj.vo.menu.MenuResponseVo;
import kr.co.baseprj.vo.menu.SubMenuSaveVo;
import kr.co.baseprj.vo.menu.TopMenuSaveVo;
import kr.co.baseprj.vo.menu.MenuVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

  private final MenuService menuService;


  @GetMapping
  public String menuForm(Model model) {
    List<MenuVo> menuList = menuService.getMenuList();
    model.addAttribute("menuList", menuList);
    return "menu/menu";
  }

  @GetMapping("/menu/{menuCd}")
  @ResponseBody
  public HashMap<String, Object> getMenu (@PathVariable("menuCd") String menuCd) {
    HashMap<String, Object> result = menuService.getByMenuCd(menuCd);
    return result;
  }

  @PostMapping("/isValidate")
  @ResponseBody
  public String isValidate(@RequestBody TopMenuSaveVo topMenuSaveVo) {
    if (menuService.isValidate(topMenuSaveVo)) {

      return "success";
    }
    return "success";
  }

  @PostMapping("save/topMenu")
  public String save(@ModelAttribute TopMenuSaveVo topMenuSaveVo) {
    String menuCd = topMenuSaveVo.getTopMenuCd();

    if (menuService.isDuplicated(menuCd)) {

    }
    MenuVo menuVo = MenuVo.from(topMenuSaveVo);

    menuService.saveMenu(menuVo);
    return "redirect:/menu";
  }

  @PostMapping("save/subMenu")
  @ResponseBody
  public String saveSub(@RequestBody SubMenuSaveVo subMenuSaveVo) {
    log.info("subMenuSaveVo={}", subMenuSaveVo);

    if (menuService.isValidate(subMenuSaveVo)) {
      MenuVo menuVo = MenuVo.from(subMenuSaveVo);

      menuService.saveSubMenu(menuVo);
    }
    return "save";
  }
}
