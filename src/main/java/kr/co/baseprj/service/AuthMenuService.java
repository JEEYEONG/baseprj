package kr.co.baseprj.service;

import java.util.List;
import kr.co.baseprj.mapper.AuthMenuMapper;
import kr.co.baseprj.vo.authMenu.AuthMenuVo;
import kr.co.baseprj.vo.menu.MenuVo;
import kr.co.baseprj.vo.user.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthMenuService {

  private final AuthMenuMapper authMenuMapper;

  public int save(AuthMenuVo authMenuVo) {

    authMenuVo.setUseYn("Y");
    authMenuVo.setDelYn("N");
    authMenuVo.setModrId(authMenuVo.getModrId());
    authMenuVo.setModDt(authMenuVo.getModDt());

    Integer result = authMenuMapper.saveMenu(authMenuVo);
    return result;
  }

  public List<MenuVo> menuList() {
    return authMenuMapper.getMenuList();
  }


  public List<AuthMenuVo> authMenuList() {
    return authMenuMapper.getAMenuList();
  }
}
