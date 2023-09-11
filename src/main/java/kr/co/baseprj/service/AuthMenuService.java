package kr.co.baseprj.service;

import java.util.List;
import kr.co.baseprj.mapper.AuthMenuMapper;
import kr.co.baseprj.vo.authMenu.AuthMenuVo;
import kr.co.baseprj.vo.menu.MenuSaveVo;
import kr.co.baseprj.vo.menu.MenuVo;
import kr.co.baseprj.vo.user.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthMenuService {
  private final AuthMenuMapper authMenuMapper;

  public void save(AuthMenuVo authMenuVo) {
    authMenuMapper.saveMenu(authMenuVo);


  }

  public List<MenuVo> menuList() {
    return authMenuMapper.getMenuList();
  }

  public List<UserVo> userList() {
    return authMenuMapper.getUserList();
  }
}
