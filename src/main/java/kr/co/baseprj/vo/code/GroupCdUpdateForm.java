package kr.co.baseprj.vo.code;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Setter
@Getter
public class GroupCdUpdateForm {
    private String groupCd;
    private String groupCdNm;
    private String delYn;
    private String descrt;
    private String modrId;
    private Date modDt;
}
