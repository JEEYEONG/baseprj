package kr.co.baseprj.mgmt.codemgmt.vo;

import javax.validation.constraints.NotBlank;
import kr.co.soundtag.admin.common.bassclass.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 코드 관리
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CodeVO extends BaseVO {

    @NotBlank(message = "코드를 입력 해주세요.")
    private String code ;

    private String groupCode ;

    @NotBlank(message = "코드 명를 입력 해주세요.")
    private String codeName ;

    // 설명
    private String cont ;

    // 노출 순서
    private int displSort;

}
