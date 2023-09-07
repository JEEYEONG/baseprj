package kr.co.baseprj.service;

import kr.co.baseprj.paging.SearchCondition;
import kr.co.baseprj.vo.code.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CodeService {
    Integer save(GroupCodeVo groupCodeVo);

    boolean isValidate(GroupCodeSaveForm saveForm);

    boolean isValidate(StCodeSaveForm saveForm);

    boolean isValidate(GroupCdUpdateForm updateForm);

    Optional<GroupCodeVo> getByGroupCd(String groupCd);

    int getResultCnt(SearchCondition sc);

    List<GroupCodeVo> getCodeList(SearchCondition sc);

    Integer getStCodeResultCnt(SearchCondition sc);

    Integer save(StCodeVo stCodeVo);

    List<StCodeVo> getStCodeList(SearchCondition sc);

    Integer deleteStCd(Map<String, Object> param);

    Integer updateGroupCd(GroupCdUpdateForm updateForm);

}
