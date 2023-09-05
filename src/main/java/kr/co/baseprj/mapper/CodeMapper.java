package kr.co.baseprj.mapper;

import kr.co.baseprj.paging.SearchCondition;
import kr.co.baseprj.vo.code.GroupCodeVo;
import kr.co.baseprj.vo.code.StCodeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface CodeMapper {
    List<GroupCodeVo> findCodeList(SearchCondition sc);

    Integer saveCode(GroupCodeVo groupCodeVo);

    Optional<GroupCodeVo> findByGroupCd(String groupCd);

    int searchResultCnt(SearchCondition sc);

    Integer searchStCodeResultCnt(SearchCondition sc);

    StCodeVo findStCodeByCdNm(Map<String, Object> map);
}
