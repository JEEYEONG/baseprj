package kr.co.baseprj.vo.menu;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MenuVo {
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
}
