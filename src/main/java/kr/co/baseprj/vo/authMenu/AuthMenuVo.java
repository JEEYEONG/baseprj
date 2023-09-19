package kr.co.baseprj.vo.authMenu;

import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthMenuVo {

  private String authGroupCd; // 권한그룹코드
  private String useYn; //사용여부
  private String regrId; //등록자아이디
  private Date regDt; //등록일시
  private String DelYn; //삭제여부
  private String modrId; // 수정자아이디
  private Date modDt; //수정일시

  private String menuCd; // menuCd


  @Builder
  public AuthMenuVo(String useYn, String regrId, Date regDt, String delYn, String modrId,
      Date modDt,
      String menuCd, String authGroupCd) {
    this.useYn = useYn;
    this.regrId = regrId;
    this.regDt = regDt;
    this.DelYn = delYn;
    this.modrId = modrId;
    this.modDt = modDt;
    this.menuCd = menuCd;
    this.authGroupCd = authGroupCd;
  }


}
