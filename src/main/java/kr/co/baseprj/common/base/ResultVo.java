package kr.co.baseprj.common.base;

import lombok.Data;

@Data
public class ResultVo {

    //결과 코드
    private String resultCode;

    //결과 메시지
    private String resultMsg;

    //결과 Object
    private Object data;
}
