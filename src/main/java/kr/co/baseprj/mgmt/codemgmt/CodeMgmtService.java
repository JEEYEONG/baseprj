package kr.co.baseprj.mgmt.codemgmt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kr.co.soundtag.admin.common.bassclass.Constant;
import kr.co.soundtag.admin.common.bassclass.PageNavigator;
import kr.co.soundtag.admin.common.bassclass.ResultVO;
import kr.co.soundtag.admin.common.exception.BizException;
import kr.co.soundtag.admin.common.exception.ErrorCode;
import kr.co.soundtag.admin.system.codemgmt.vo.CodeVO;
import kr.co.soundtag.admin.system.codemgmt.vo.GroupCodeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CodeMgmtService {

    @Autowired
    CodeMgmtDao codeMgmtDao;

    /**
     * 목록 조회
     * @param param
     * @param pageNavigator
     * @return
     */
    List<GroupCodeVO> selectGroupCodeList(GroupCodeVO param, PageNavigator pageNavigator) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("p", pageNavigator);
        paramMap.put("i", param);

        return codeMgmtDao.selectGroupCodeList(paramMap);
    }

    /**
     * 목록 총 갯수
     * @param param
     * @param pageNavigator
     * @return
     */
    int selectGroupCodeCount(GroupCodeVO param, PageNavigator pageNavigator) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("p",pageNavigator);
        paramMap.put("i", param);

        return codeMgmtDao.selectGroupCodeCount(paramMap);
    }

    /**
     * 상세 조회
     * @param param
     * @return
     */
    GroupCodeVO selectGroupCode(GroupCodeVO param){
        return codeMgmtDao.selectGroupCode(param);
    }

    /**
     * 등록
     * @param param
     * @return
     */
    ResultVO insertGroupCode(GroupCodeVO param){

        ResultVO resultVO = new ResultVO();
        GroupCodeVO groupCodeVO = codeMgmtDao.selectGroupCode(param);

        if(groupCodeVO != null ){
            throw new BizException(ErrorCode.DUPLICATION_CODE);
        }

        int result = codeMgmtDao.insertGroupCode(param);

        if(result == 0){
            throw new BizException(ErrorCode.TRANSACTION_FAIL);
        }else{
            resultVO.setResultCode(Constant.SUCCESS_CODE);
            resultVO.setResultMsg(Constant.SUCCESS_CODE_MSG);
        }

        return resultVO;
    }

    /**
     * 수정
     * @param param
     * @return
     */
    ResultVO updateGroupCode(GroupCodeVO param){
        ResultVO resultVO = new ResultVO();
        int result = codeMgmtDao.updateGroupCode(param);

        if(result == 0){
            throw new BizException(ErrorCode.TRANSACTION_FAIL);
        }else{
            resultVO.setResultCode(Constant.SUCCESS_CODE);
            resultVO.setResultMsg(Constant.SUCCESS_CODE_MSG);
        }

        return resultVO;
    }

    /**
     * 삭제
     * @param param
     * @return
     */
    ResultVO deleteGroupCode(GroupCodeVO param){
        ResultVO resultVO = new ResultVO();
        int result = codeMgmtDao.deleteGroupCode(param);

        if(result == 0){
            throw new BizException(ErrorCode.TRANSACTION_FAIL);
        }else{
            resultVO.setResultCode(Constant.SUCCESS_CODE);
            resultVO.setResultMsg(Constant.SUCCESS_CODE_MSG);
        }

        return resultVO;
    }

    /**
     * 코드 조회
     * @param param
     * @return
     */
    public List<CodeVO> selectCodeList(GroupCodeVO param) {

        return codeMgmtDao.selectCodeList(param);
    }

    /**
     * 코드 저장
     * @param codeList
     * @return
     */
    ResultVO insertCode(List<CodeVO> codeList, String userId){
        // 채번
        ResultVO resultVO = new ResultVO();

        List<CodeVO> param = new ArrayList<>() ;

        int i = 1;
        for (CodeVO codeVO: codeList) {
            codeVO.setDisplSort(i++);
            codeVO.setMngrId(userId);
            param.add(codeVO);
        }

        log.debug(param.toString());

        // 삭제 처리
        codeMgmtDao.deleteCode(param.get(0));

        int result = codeMgmtDao.insertCode(param);

        if(result == 0){
            throw new BizException(ErrorCode.TRANSACTION_FAIL);
        }else{
            resultVO.setResultCode(Constant.SUCCESS_CODE);
            resultVO.setResultMsg(Constant.SUCCESS_CODE_MSG);
        }

        return resultVO;
    }

    /**
     * 코드 조회
     * @param param
     * @return
     */
    public CodeVO selectCode(CodeVO param) {

        return codeMgmtDao.selectCode(param);
    }
}
