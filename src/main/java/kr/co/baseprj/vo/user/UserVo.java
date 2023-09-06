package kr.co.baseprj.vo.user;

import java.time.LocalDateTime;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserVo {

  @NotBlank(message = "아이디를 입력해주세요")
  private String userId; //아이디

  @NotBlank(message = "이름을 입력해주세요")
  private String userNm; //이름

  @NotBlank(message = "등급을 입력해주세요")
  private String authGroupCd; //권한그룹코드 등급 ROOT ADMIN USER
  
  @NotBlank(message = "비밀번호를 입력해주세요")
  private String secretNum; //비밀번호

  private Date regDt; //등록일시

  private Date modDt; //수정일시

  private String regrId; //등록자 아이디 currentUser

  private String modrId; //수정자 아이디

  private String delYn; //삭제여부
  
  private String userDiv; //사용자구분 서울지점

  @Builder
  public UserVo(String userId, String userNm, String authGroupCd, String secretNum,
      Date regDt, Date modDt, String regrId, String modrId, String delYn,
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
