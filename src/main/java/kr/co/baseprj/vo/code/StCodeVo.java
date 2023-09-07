package kr.co.baseprj.vo.code;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
@Builder
public class StCodeVo {
    private String cd;
    private String stCdNm;
    private String descrt;
    private Integer displSort;
    private String regrId;
    private Date regDt;
    private String modrId;
    private Date modDt;
    private String delYn;
    private String groupCd;

    public static StCodeVo from(StCodeSaveForm saveForm) {
        return StCodeVo.builder()
                .cd(saveForm.getCd())
                .stCdNm(saveForm.getStCdNm())
                .descrt(saveForm.getDescrt())
                .displSort(0)
                .delYn(saveForm.getDelYn())
                .groupCd(saveForm.getGroupCd())
                .build();
    }
}
