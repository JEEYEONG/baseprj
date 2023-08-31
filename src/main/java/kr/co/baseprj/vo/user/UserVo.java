package kr.co.baseprj.vo.user;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
public class UserVo {

  private String userId; //아이디
  private String userNm; //이름
  private String authGroupCd; //권한그룹코드 ROOT ADMIN USER
  private String secretNum; //비밀번호
  private LocalDateTime regDt; //등록일시
  private LocalDateTime modDt; //수정일시
  private String regrId; //등록자 아이디 currentUser
  private String modrId; //수정자 아이디
  private String delYn; //삭제여부
  private String userDiv; //사용자 구분 ADMIN USER?

  @Builder
  public UserVo(String userId, String userNm, String authGroupCd, String secretNum,
      LocalDateTime regDt, LocalDateTime modDt, String regrId, String modrId, String delYn,
      String userDiv) {
    this.userId = userId;
    this.userNm = userNm;
    this.authGroupCd = authGroupCd;
    this.secretNum = secretNum;
    this.regDt = regDt;
    this.modDt = modDt;
    this.regrId = regrId;
    this.modrId = modrId;
    this.delYn = delYn;
    this.userDiv = userDiv;
  }
}
