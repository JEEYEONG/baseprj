package kr.co.baseprj.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import kr.co.baseprj.vo.menu.TopMenuSaveVo;
import kr.co.baseprj.vo.menu.MenuVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {

  Optional<MenuVo> findByMenuCd(String menuCd);

  Integer saveMenu(MenuVo menuVo);

  List<MenuVo> findMenuList();


  int getMaxCateCd();

  int getMaxDvsCd();

  List<MenuVo> findSubmenuList(HashMap<String, Object> param);
}