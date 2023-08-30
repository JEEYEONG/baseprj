package kr.co.baseprj.vo.user;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserVo {
    private String userId; //아이디
    private String userNm; //이름
    private String authGroupCd; //권한그룹코드
    private String secretNum; //비밀번호
    private LocalDateTime regDt; //등록일시
    private LocalDateTime modDt; //수정일시
    private String regrId; //등록자 아이디
    private String modrId; //수정자 아이디
    private String delYn; //삭제여부
    private String userDiv; //사용자 구분

}
