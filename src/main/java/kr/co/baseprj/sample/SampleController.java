package kr.co.baseprj.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class SampleController {

    @Autowired
    SampleService sampleService;

    @RequestMapping("/sample/list")
    public String getSampleList(Model model) throws Exception {
        log.debug("SAMPLE START ");

        model.addAttribute("list", sampleService.getSampleList());

        return "sample/list";
    }


}
