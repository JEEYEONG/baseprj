package kr.co.baseprj.service;

import kr.co.baseprj.exception.AlreadyExistException;
import kr.co.baseprj.exception.NotEmptyException;
import kr.co.baseprj.mapper.CodeMapper;
import kr.co.baseprj.paging.SearchCondition;
import kr.co.baseprj.vo.code.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {
    private final CodeMapper codeMapper;

    @Override
    public Integer save(GroupCodeVo groupCodeVo) {
        Integer result = codeMapper.saveCode(groupCodeVo);
        return result;
    }

    @Override
    public boolean isValidate(GroupCodeSaveForm saveForm) {
        if (!StringUtils.hasText(saveForm.getGroupCd())) {
            throw new NotEmptyException("공통 코드를 입력해주세요");
        } else if (!StringUtils.hasText(saveForm.getGroupCdNm())) {
            throw new NotEmptyException("공통 코드 명을 입력해주세요");
        } else if (isAlreadyExist(saveForm)) {
            throw new AlreadyExistException("이미 등록 된 공통 코드 입니다.");
        }
        return true;
    }

    @Override
    public Optional<GroupCodeVo> getByGroupCd(String groupCd) {
        return codeMapper.findByGroupCd(groupCd);
    }


    @Override
    public int getResultCnt(SearchCondition sc) {
        return codeMapper.searchResultCnt(sc);
    }

    @Override
    public List<GroupCodeVo> getCodeList(SearchCondition sc) {
        return codeMapper.findCodeList(sc);
    }

    @Override
    public Integer getStCodeResultCnt(SearchCondition sc) {
        return codeMapper.searchStCodeResultCnt(sc);
    }

    @Override
    public boolean isValidate(StCodeSaveForm saveForm) {
        if (!StringUtils.hasText(saveForm.getCd())) {
            throw new NotEmptyException("코드를 입력해주세요");
        } else if (!StringUtils.hasText(saveForm.getStCdNm())) {
            throw new NotEmptyException("코드 명을 입력해주세요");
        } else if (isAlreadyExist(saveForm)) {
            throw new AlreadyExistException("이미 등록 된 공통 코드 입니다.");
        }
        return true;
    }

    @Override
    public boolean isValidate(GroupCdUpdateForm updateForm) {
        if (!StringUtils.hasText(updateForm.getGroupCdNm())) {
            throw new NotEmptyException("구분 코드 명을 입력해주세요");
        }
        return true;
    }

    @Override
    public Integer updateGroupCd(GroupCdUpdateForm updateForm) {
        return codeMapper.updateGroupCd(updateForm);
    }

    @Override
    public Integer save(StCodeVo stCodeVo) {
        return codeMapper.saveStCode(stCodeVo);
    }

    @Override
    public List<StCodeVo> getStCodeList(SearchCondition sc) {
        return codeMapper.findStCodeList(sc);
    }

    @Override
    public Integer deleteStCd(Map<String, Object> param) {
        return codeMapper.deleteStCd(param);
    }

    private boolean isAlreadyExist(GroupCodeSaveForm saveForm) {
        Optional<GroupCodeVo> groupCodeVo = codeMapper.findByGroupCd(saveForm.getGroupCd());
        return groupCodeVo.isEmpty() ? false : true;
    }

    private boolean isAlreadyExist(StCodeSaveForm saveForm) {
        Map<String, Object> map = new HashMap<>();
        map.put("cd", saveForm.getCd());
        map.put("groupCd", saveForm.getGroupCd());

        Optional<StCodeVo> stCodeVo = codeMapper.findStCodeByCdNm(map);
        return stCodeVo.isEmpty() ? false : true;
    }
}
