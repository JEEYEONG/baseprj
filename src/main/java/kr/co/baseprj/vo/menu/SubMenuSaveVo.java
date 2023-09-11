package kr.co.baseprj.vo.menu;

import lombok.Data;

@Data
public class SubMenuSaveVo {
  private String parentMenuCd;

  private String subMenuNm;

  private String subLinkUrl;

  private String subDisplYn;
}