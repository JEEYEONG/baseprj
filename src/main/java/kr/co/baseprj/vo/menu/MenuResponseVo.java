package kr.co.baseprj.vo.menu;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenuResponseVo {
  private String menuCd;
  private String menuNm;
  private String cateCd;
  private String linkUrl;
  private List<MenuVo> subMenuList;

  public static MenuResponseVo from(MenuVo menuVo, List<MenuVo> subMenulist) {
    return MenuResponseVo.builder()
        .menuCd(menuVo.getMenuCd())
        .menuNm(menuVo.getMenuNm())
        .linkUrl(menuVo.getLinkUrl())
        .cateCd(menuVo.getCateCd())
        .subMenuList(subMenulist)
        .build();
  }
}
