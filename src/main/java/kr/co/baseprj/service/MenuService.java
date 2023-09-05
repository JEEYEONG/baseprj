package kr.co.baseprj.service;

import java.util.List;
import kr.co.baseprj.vo.menu.MenuSaveVo;
import kr.co.baseprj.vo.menu.MenuVo;

public interface MenuService {

  boolean isValidate(MenuSaveVo menuSaveVo);

  List<MenuVo> getMenuList();
}
