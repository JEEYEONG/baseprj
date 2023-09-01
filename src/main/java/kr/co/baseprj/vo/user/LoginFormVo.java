package kr.co.baseprj.vo.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 로그인 폼 데이터를 받기 위한 클래스
 */
@Getter
@Setter
public class LoginFormVo {

  @NotEmpty(message = "아이디를 입력해주세요")
  private String userId;

  @NotEmpty(message = "비밀번호를 입력해주세요")
  private String secretNum;

  public LoginFormVo() {
  }

  @Builder
  public LoginFormVo(String userId, String secretNum) {
    this.userId = userId;
    this.secretNum = secretNum;
  }
}
