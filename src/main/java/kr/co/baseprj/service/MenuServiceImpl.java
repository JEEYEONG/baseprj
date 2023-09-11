package kr.co.baseprj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import kr.co.baseprj.exception.MenuSaveExceptionCode;
import kr.co.baseprj.exception.MenuSaveVoException;
import kr.co.baseprj.mapper.MenuMapper;
import kr.co.baseprj.vo.menu.MenuVo;
import kr.co.baseprj.vo.menu.SubMenuSaveVo;
import kr.co.baseprj.vo.menu.TopMenuSaveVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

  private final MenuMapper menuMapper;

  @Override
  public boolean isValidate(TopMenuSaveVo topMenuSaveVo) {

    if (!Pattern.matches("^[A-Za-z]{2,9}$", topMenuSaveVo.getTopMenuNm())) {
      throw new MenuSaveVoException("에러 발생", MenuSaveExceptionCode.TOP_MENU_NM_INVALID);
    }

    if (!Pattern.matches("^[a-zA-Z]{3,10}$", topMenuSaveVo.getTopLinkUrl())) {
      throw new MenuSaveVoException("에러 발생", MenuSaveExceptionCode.TOP_MENU_LINK_URL);
    }

    return true;
  }

  @Override
  public boolean isValidate(SubMenuSaveVo subMenuSaveVo) {
    if(!StringUtils.hasText(subMenuSaveVo.getParentMenuCd())) {
      throw new MenuSaveVoException("에러 발생", MenuSaveExceptionCode.TOP_MENU_CD_EMPTY);
    }
    if(!Pattern.matches("^[A-Za-z]{2,9}$", subMenuSaveVo.getSubMenuNm())) {
      throw new MenuSaveVoException("에러 발생", MenuSaveExceptionCode.SUB_MENU_NM_INVALID);
    }
    if(!Pattern.matches("^[A-Za-z]{2,9}$", subMenuSaveVo.getSubLinkUrl())) {
      throw new MenuSaveVoException("에러 발생", MenuSaveExceptionCode.SUB_MENU_LINK_URL_INVALID);
    }
    return true;
  }

  @Override
  public void saveMenu(MenuVo menuVo) {
    int maxCateCd = menuMapper.getMaxCateCd();
    menuVo.setCateSort(maxCateCd);

    String cateCd = strLeftZero(String.valueOf(maxCateCd), 2);
    menuVo.setCateCd(cateCd);

    String menuCd = cateCd + nullToEmpty(menuVo.getDvsCd());
    menuVo.setMenuCd(menuCd);

    menuMapper.saveMenu(menuVo);
  }

  @Override
  public void saveSubMenu(MenuVo menuVo) {
    String cateCd = menuVo.getCateCd();
    menuVo.setCateCd(cateCd);;
    int maxDvsCd = menuMapper.getMaxDvsCd();
    menuVo.setDvsSort(maxDvsCd);

    String dvsCd = strLeftZero(String.valueOf(maxDvsCd), 2);
    menuVo.setDvsCd(dvsCd);

    String menuCd = cateCd + nullToEmpty(menuVo.getDvsCd());
    menuVo.setMenuCd(menuCd);

    menuMapper.saveMenu(menuVo);
  }

  public List<MenuVo> getMenuList() {
    List<MenuVo> menuList = menuMapper.findMenuList();
    log.info("menuList={}", menuList);
    return menuList;
  }

  @Override
  public HashMap<String, Object> getByMenuCd(String menuCd) {
    Optional<MenuVo> menu = menuMapper.findByMenuCd(menuCd);
    menu.orElseThrow(() -> new RuntimeException());
    MenuVo menuVo = menu.get();
    HashMap<String, Object> param = new HashMap<>();
    param.put("cateCd", menuVo.getCateCd());
    param.put("depth", 1);

    List<MenuVo> submenuList = menuMapper.findSubmenuList(param);

    HashMap<String, Object> map = new HashMap<>();
    map.put("menuVo", menuVo);
    if(submenuList != null) {
      map.put("submenuList", submenuList);
    }

    return map;
  }


  @Override
  public boolean isDuplicated(String menuCd) {
    return false;
  }

  private String strLeftZero(String str, int length) {
    int strLength = str.length();
    if(strLength >= length) {
      return str;
    }else{
      int spaceLength = length - strLength;
      for (int i = 0; i < spaceLength; i++) {
        str = "0" + str;
      }
      return str;
    }
  }


  public String nullToEmpty(String str) {
    return (str == null) ? "" : str;
  }
}
