package kr.co.baseprj.mgmt.codemgmt.vo;

import javax.validation.constraints.NotBlank;
import kr.co.soundtag.admin.common.bassclass.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 그룹 코드 관리
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GroupCodeVO extends BaseVO {


    @NotBlank(message = "그룹 코드를 입력 주세요.")
    private String groupCode ;

    @NotBlank(message = "그룹 코드 명를 입력 주세요.")
    private String groupCodeName ;

    private String searchGroupCode;

    // 설명
    private String cont ;



}
