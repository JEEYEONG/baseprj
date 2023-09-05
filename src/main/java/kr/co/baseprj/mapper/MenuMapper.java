package kr.co.baseprj.mapper;

import java.util.List;
import java.util.Optional;
import kr.co.baseprj.vo.menu.MenuSaveVo;
import kr.co.baseprj.vo.menu.MenuVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {

  Optional<MenuVo> findByMenuCd(String menuCd);

  Integer save(MenuSaveVo menuSaveVo);

  List<MenuVo> findMenuList();
}