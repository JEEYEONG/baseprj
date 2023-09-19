package kr.co.baseprj.controller;

import kr.co.baseprj.paging.PageHandler;
import kr.co.baseprj.paging.SearchCondition;
import kr.co.baseprj.service.CodeService;
import kr.co.baseprj.vo.code.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        model.addAttribute("ph", ph);
        return "code/codeList";
    }

    @GetMapping("/save")
    public String saveForm(HttpServletRequest request, Model model) {
        String referer = request.getHeader("referer");
        model.addAttribute("referer", referer);

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

        List<StCodeVo> stCodeList = getStCodeList(sc);

        model.addAttribute("stCodeList", stCodeList);

        model.addAttribute("sc", sc);
        model.addAttribute("ph", ph);
        return "code/code-detail";
    }

    @PostMapping("/{groupCd}/{cd}")
    @ResponseBody
    public Map<String, Object> saveStCode(@PathVariable String cd,
                                          @PathVariable String groupCd,
                                          @RequestBody StCodeSaveForm saveForm,
                                          HttpServletRequest request
    ) {
        log.info("request.getServletPath().toString()={}", request.getServletPath().toString());

        String referer = request.getHeader("referer");
        if (codeService.isValidate(saveForm)) {
            StCodeVo stCodeVo = StCodeVo.from(saveForm);

            Integer result = codeService.save(stCodeVo);

            if (result != 1)
                throw new RuntimeException("fail");
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result", "success");
        resultMap.put("referer", referer);
        return resultMap;
    }

    @PostMapping("/delete/stCd")
    @ResponseBody
    public Map<String, Object> deleteStCode(@RequestBody Map<String, Object> param, HttpServletRequest request) {
        Integer result = codeService.deleteStCd(param);

        String referer = request.getHeader("referer");

        if (result != 1)
            throw new RuntimeException("fail");

        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("result", "success");
        resultMap.put("referer", referer);

        return resultMap;
    }

    @PostMapping("/update/groupCd")
    @ResponseBody
    public String updateGroupCd(@RequestBody GroupCdUpdateForm updateForm) {

        if (codeService.isValidate(updateForm)) {
            Integer result = codeService.updateGroupCd(updateForm);

            if (result != 1)
                throw new RuntimeException("fail");
        }

        if (updateForm.getDelYn().equals("Y"))
            return "delete";

        return "success";
    }

    private List<StCodeVo> getStCodeList(SearchCondition sc) {
        List<StCodeVo> stCodeList = codeService.getStCodeList(sc);
        return stCodeList;
    }

    private GroupCodeVo getGroupCode(String groupCd) {
        GroupCodeVo groupCode = codeService.getByGroupCd(groupCd).get();
        return groupCode;
    }
}
