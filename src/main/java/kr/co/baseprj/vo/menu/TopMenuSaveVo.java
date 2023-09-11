package kr.co.baseprj.vo.menu;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TopMenuSaveVo {

  private String topMenuCd;

  private String topMenuNm;

  private String topLinkUrl;

  private String topDisplYn;
  private String cateCd;
  private Integer depth;


}
