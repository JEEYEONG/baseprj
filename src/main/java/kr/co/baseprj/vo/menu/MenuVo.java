package kr.co.baseprj.vo.menu;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class MenuVo{
  private String menuCd;
  private String menuNm;
  private Integer depth;
  private String cateCd;
  private String dvsCd;
  private String sectCd;
  private Integer cateSort;
  private Integer dvsSort;
  private Integer sectSort;
  private String linkUrl;
  private String delYn;
  private String modrId;
  private Date modDt;
  private String regrId;
  private Date regrDt;
  private String icon;
  private String displYn;

  public static MenuVo from(TopMenuSaveVo topMenuSaveVo) {
    return MenuVo.builder()
        .menuCd(topMenuSaveVo.getTopMenuCd())
        .menuNm(topMenuSaveVo.getTopMenuNm())
        .linkUrl(topMenuSaveVo.getTopLinkUrl())
        .depth(topMenuSaveVo.getDepth())
        .cateCd(topMenuSaveVo.getCateCd())
        .displYn(topMenuSaveVo.getTopDisplYn())
        .delYn("N")
        .build();
  }

  public static MenuVo from(SubMenuSaveVo subMenuSaveVo) {
    return MenuVo.builder()
        .menuCd("")
        .menuNm(subMenuSaveVo.getSubMenuNm())
        .cateCd(subMenuSaveVo.getParentMenuCd())
        .depth(2)
        .displYn("Y")
        .delYn("N")
        .build();
  }
}