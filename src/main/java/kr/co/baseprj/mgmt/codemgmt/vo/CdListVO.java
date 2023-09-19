package kr.co.baseprj.mgmt.codemgmt.vo;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import kr.co.soundtag.admin.common.bassclass.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 코드 관리
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CdListVO extends BaseVO {

    @Valid
    @NotNull(message = "코드 정보를 입력해 주세요.")
    @Size(min = 1 , message = "코드 정보를 입력해 주세요.")
    List<CodeVO> cdList;
}
