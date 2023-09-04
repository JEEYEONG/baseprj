package kr.co.baseprj.vo.menu;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MenuSaveVo {

  private String menuCd;

  private String menuNm;

  private String linkUrl;

  private String displYn;
  private String regrId;
  private Date regDt;
  private String modrId;
  private Date modrDt;
}
