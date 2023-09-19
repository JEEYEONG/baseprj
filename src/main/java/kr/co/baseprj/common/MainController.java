package kr.co.baseprj.common;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(HttpServletResponse response) throws IOException {
        return "redirect:/";
    }
}
