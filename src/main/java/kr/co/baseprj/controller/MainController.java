package kr.co.baseprj.controller;

import kr.co.baseprj.service.UserService;
import kr.co.baseprj.vo.user.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(){
        return "main";
    }



}
