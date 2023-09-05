package kr.co.baseprj.vo.code;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class StCodeVo {
    private String cd;
    private String cdNm;
    private String descrt;
    private Integer displSort;
    private String regrId;
    private Date regDt;
    private String modrId;
    private Date modDt;
    private String delYn;
    private String groupCd;
}
