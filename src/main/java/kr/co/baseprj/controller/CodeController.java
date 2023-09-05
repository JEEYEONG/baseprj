package kr.co.baseprj.controller;

import kr.co.baseprj.paging.PageHandler;
import kr.co.baseprj.paging.SearchCondition;
import kr.co.baseprj.service.CodeService;
import kr.co.baseprj.vo.code.GroupCodeSaveForm;
import kr.co.baseprj.vo.code.GroupCodeVo;
import kr.co.baseprj.vo.code.StCodeSaveForm;
import kr.co.baseprj.vo.code.StCodeVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/code")
public class CodeController {
    private final CodeService codeService;

    @GetMapping("/codeList")
    public String main(SearchCondition sc, Model model) {
        int totalCnt = codeService.getResultCnt(sc);
        PageHandler ph = new PageHandler(totalCnt, sc);
        List<GroupCodeVo> codeList = codeService.getCodeList(sc);
        model.addAttribute("codeList", codeList);
        return "code/codeList";
    }

    @GetMapping("/save")
    public String saveForm() {
        return "code/codeSave";
    }

    @PostMapping("/save")
    @ResponseBody
    public String save(@RequestBody GroupCodeSaveForm saveForm) {
        if (codeService.isValidate(saveForm)) {
            GroupCodeVo groupCodeVo = GroupCodeVo.from(saveForm);
            Integer result = codeService.save(groupCodeVo);
            if (result != 1)
                throw new RuntimeException("fail");
        }

        return "success";
    }

    @GetMapping("/{groupCd}")
    public String detailForm(@PathVariable String groupCd,
                             @ModelAttribute SearchCondition sc,
                             Model model
    ) {
        Integer totalCnt = codeService.getStCodeResultCnt(sc);
        PageHandler ph = new PageHandler(totalCnt, sc);

        GroupCodeVo groupCode = getGroupCode(groupCd);
        model.addAttribute("groupCode", groupCode);

        getStCodeList(groupCd, sc);
        return "code/code-detail";
    }

    @PostMapping("/{groupCd}/{cd}")
    @ResponseBody
    public String saveStCode(@PathVariable String cd,
                             @PathVariable String groupCd,
                             @RequestBody StCodeSaveForm saveForm,
                             HttpServletRequest request
                             ) {
        log.info("request.getServletPath().toString()={}", request.getServletPath().toString());
        if (codeService.isValidate(saveForm)) {

        };
        return null;
    }

    private List<StCodeVo> getStCodeList(String groupCd, SearchCondition sc) {
        return null;
    }

    private GroupCodeVo getGroupCode(String groupCd) {
        GroupCodeVo groupCode = codeService.getByGroupCd(groupCd).get();
        return groupCode;
    }
}
