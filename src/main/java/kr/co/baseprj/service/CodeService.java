package kr.co.baseprj.service;

import kr.co.baseprj.paging.SearchCondition;
import kr.co.baseprj.vo.code.GroupCodeSaveForm;
import kr.co.baseprj.vo.code.GroupCodeVo;
import kr.co.baseprj.vo.code.StCodeSaveForm;

import java.util.List;
import java.util.Optional;

public interface CodeService {
    Integer save(GroupCodeVo groupCodeVo);

    boolean isValidate(GroupCodeSaveForm saveForm);

    boolean isValidate(StCodeSaveForm saveForm);

    Optional<GroupCodeVo> getByGroupCd(String groupCd);

    int getResultCnt(SearchCondition sc);

    List<GroupCodeVo> getCodeList(SearchCondition sc);

    Integer getStCodeResultCnt(SearchCondition sc);

}
