package kr.co.baseprj.mapper;

import java.util.List;
import kr.co.baseprj.vo.authMenu.AuthMenuVo;
import kr.co.baseprj.vo.menu.MenuSaveVo;
import kr.co.baseprj.vo.menu.MenuVo;
import kr.co.baseprj.vo.user.UserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMenuMapper {


  void saveMenu(AuthMenuVo authMenuVo);

  List<MenuVo> getMenuList();

  List<UserVo> getUserList();
}
