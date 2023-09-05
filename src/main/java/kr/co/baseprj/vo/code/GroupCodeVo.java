package kr.co.baseprj.vo.code;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
public class GroupCodeVo {
    String groupCd;
    String groupCdNm;
    String descrt;
    String regrId;
    Date regDt;
    String modrId;
    Date modDt;
    String delYn;

    public static GroupCodeVo from(GroupCodeSaveForm saveForm) {
        return GroupCodeVo.builder()
                .groupCd(saveForm.getGroupCd())
                .groupCdNm(saveForm.getGroupCdNm())
                .delYn("N")
                .descrt(saveForm.getDescrt())
                .build();
    }
}
