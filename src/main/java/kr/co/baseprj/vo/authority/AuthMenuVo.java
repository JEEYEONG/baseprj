package kr.co.baseprj.vo.authority;

import java.util.Date;
import kr.co.baseprj.vo.menu.MenuVo;
import kr.co.baseprj.vo.user.UserVo;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthMenuVo {

  private String useYn; //사용여부
  private String regrId; //등록자아이디
  private Date regDt; //등록일시
  private String DelYt; //삭제여부
  private String modrId; // 수정자아이디
  private Date modDt; //수정일시

  private MenuVo menuVo; // menuCd
  private UserVo userVo; // authGroupCd

  @Builder
  public AuthMenuVo(String useYn, String regrId, Date regDt, String delYt, String modrId,
      Date modDt,
      MenuVo menuVo, UserVo userVo) {
    this.useYn = useYn;
    this.regrId = regrId;
    this.regDt = regDt;
    DelYt = delYt;
    this.modrId = modrId;
    this.modDt = modDt;
    this.menuVo = menuVo;
    this.userVo = userVo;
  }


}
