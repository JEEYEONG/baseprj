package kr.co.baseprj.mgmt.codemgmt;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import kr.co.soundtag.admin.common.bassclass.BaseController;
import kr.co.soundtag.admin.common.bassclass.Constant;
import kr.co.soundtag.admin.common.bassclass.PageNavigator;
import kr.co.soundtag.admin.common.bassclass.ResultVO;
import kr.co.soundtag.admin.common.utils.UserSessUtil;
import kr.co.soundtag.admin.system.codemgmt.vo.CdListVO;
import kr.co.soundtag.admin.system.codemgmt.vo.CodeVO;
import kr.co.soundtag.admin.system.codemgmt.vo.GroupCodeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Slf4j
public class CodeController extends BaseController {

    @Autowired
    CodeMgmtService codeMgmtService;

    /**
     * 목록 조회
     * @param model
     * @param page
     * @param groupCodeVO
     * @return
     * @throws Exception
     */
    @RequestMapping("/system/code/selectGroupCodeList")
    public String selectGroupCodeList(Model model, PageNavigator page, GroupCodeVO groupCodeVO) throws Exception {

        page = makePageNavigator();

        List<GroupCodeVO> list = codeMgmtService.selectGroupCodeList(groupCodeVO, page);

        page.setTotalSize(codeMgmtService.selectGroupCodeCount(groupCodeVO, page));

        model.addAttribute("list", list);
        model.addAttribute("s", groupCodeVO);
        model.addAttribute("p", page);

        return "system/code/list";
    }

    /**
     * 상세
     * @param model
     * @param page
     * @param groupCodeVO
     * @return
     * @throws Exception
     */
    @RequestMapping("/system/code/selectGroupCode")
    public String selectGroupCode(Model model, PageNavigator page, GroupCodeVO groupCodeVO) throws Exception {

        // 조회
        GroupCodeVO result = new GroupCodeVO();
        List<CodeVO> cdList = new ArrayList<>();

        if("D".equals(groupCodeVO.getTranMod())){
            result = codeMgmtService.selectGroupCode(groupCodeVO);
            cdList = codeMgmtService.selectCodeList(groupCodeVO);
        }

        model.addAttribute("result", result);
        model.addAttribute("cdList", cdList);
        model.addAttribute("s", groupCodeVO);
        model.addAttribute("p", page);


        return "system/code/detail";
    }

    /**
     * 등록
     * @param groupCodeVO
     * @param result
     * @return
     * @throws Exception
     */
    @RequestMapping("/system/code/insertGroupCode")
    @ResponseBody
    public ResultVO insertGroupCode(@Valid GroupCodeVO groupCodeVO, BindingResult result) throws Exception {

        log.info(groupCodeVO.toString());

        ResultVO resultVO = new ResultVO();

        // Validation Check
        if(result.hasErrors()) { //VO 유효성체크시 에러 존재
            resultVO.setResultCode(Constant.BINDING_ERRPR_CODE);
            resultVO.setResultMsg(getErrMsgValidAnnotation(result));

            return resultVO;
        }

        groupCodeVO.setMngrId(UserSessUtil.getMngrId(getRequest()));

        resultVO = codeMgmtService.insertGroupCode(groupCodeVO);


        return resultVO;
    }

    /**
     * 수정
     * @param groupCodeVO
     * @param result
     * @return
     * @throws Exception
     */
    @RequestMapping("/system/code/updateGroupCode")
    @ResponseBody
    public ResultVO updateGroupCode(@Valid GroupCodeVO groupCodeVO, BindingResult result) throws Exception {

        ResultVO resultVO = new ResultVO();

        // Validation Check
        if(result.hasErrors()) { //VO 유효성체크시 에러 존재
            resultVO.setResultCode(Constant.BINDING_ERRPR_CODE);
            resultVO.setResultMsg(getErrMsgValidAnnotation(result));

            return resultVO;
        }
        groupCodeVO.setMngrId(UserSessUtil.getMngrId(getRequest()));

        resultVO = codeMgmtService.updateGroupCode(groupCodeVO);

        return resultVO;
    }


    /**
     * 삭제
     * @param groupCodeVO
     * @return
     * @throws Exception
     */
    @RequestMapping("/system/code/deleteGroupCode")
    @ResponseBody
    public ResultVO deleteGroupCode(GroupCodeVO groupCodeVO) throws Exception {

        ResultVO resultVO = new ResultVO();

        groupCodeVO.setMngrId(UserSessUtil.getMngrId(getRequest()));

        resultVO = codeMgmtService.deleteGroupCode(groupCodeVO);

        return resultVO;
    }

    /**
     * 코드 등록
     * @param codeVO
     * @param result
     * @return
     * @throws Exception
     */
    @RequestMapping("/system/code/insertCode")
    @ResponseBody
    public ResultVO insertCode(@Valid @RequestBody CdListVO codeVO, BindingResult result) throws Exception {

        ResultVO resultVO = new ResultVO();

        log.debug("parameter :: {}", codeVO.toString());

        // Validation Check
        if(result.hasErrors()) { //VO 유효성체크시 에러 존재
            resultVO.setResultCode(Constant.BINDING_ERRPR_CODE);
            resultVO.setResultMsg(getErrMsgValidAnnotation(result));

            return resultVO;
        }

        resultVO = codeMgmtService.insertCode(codeVO.getCdList(), UserSessUtil.getMngrId(getRequest()));

        return resultVO;
    }


}
