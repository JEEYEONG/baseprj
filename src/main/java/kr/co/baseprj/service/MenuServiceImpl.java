package kr.co.baseprj.service;

import java.util.List;
import java.util.Optional;
import kr.co.baseprj.exception.AlreadyExistException;
import kr.co.baseprj.mapper.MenuMapper;
import kr.co.baseprj.vo.menu.MenuSaveVo;
import kr.co.baseprj.vo.menu.MenuVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{
  private final MenuMapper menuMapper;

  @Override
  public boolean isValidate(MenuSaveVo menuSaveVo) {
    if(isAlreadyExist(menuSaveVo)) {
      throw new AlreadyExistException("이미 등록된 경로입니다.");
    }

    menuMapper.save(menuSaveVo);
    return true;
  }

  public List<MenuVo> getMenuList() {
    List<MenuVo> menuList = menuMapper.findMenuList();
    log.info("menuList={}", menuList);
    return menuList;
  }

  private boolean isAlreadyExist(MenuSaveVo menuSaveVo) {
    log.info("menuSaveVo={}", menuSaveVo);
    String menuCd = menuSaveVo.getMenuCd();
    Optional<MenuVo> menuVo = menuMapper.findByMenuCd(menuCd);

    return menuVo.isEmpty() ? false : true;
  }
}
