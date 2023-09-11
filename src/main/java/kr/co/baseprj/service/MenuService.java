package kr.co.baseprj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import kr.co.baseprj.vo.menu.SubMenuSaveVo;
import kr.co.baseprj.vo.menu.TopMenuSaveVo;
import kr.co.baseprj.vo.menu.MenuVo;

public interface MenuService {

  boolean isValidate(TopMenuSaveVo topMenuSaveVo);

  boolean isValidate(SubMenuSaveVo subMenuSaveVo);

  List<MenuVo> getMenuList();

   void saveMenu(MenuVo menuVo);

  boolean isDuplicated(String menuCd);
  HashMap<String, Object> getByMenuCd(String menuCd);

  void saveSubMenu(MenuVo menuVo);
}
