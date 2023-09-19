package kr.co.baseprj.common.base;

import lombok.Data;

@Data
public class BaseVo {

    private String userId ; // 등록자 ID

    private String regrId ; // 등록자 ID

    private String regDt ;   // 등록 일시

    private String modrId ; // 수정자 ID

    private String modDt ;   // 수정 일시

    private String delDt ;   // 삭제 일시

    private int totalCnt;    //총 데이터 개수

    private String tranMod;  // transaction mod



}
