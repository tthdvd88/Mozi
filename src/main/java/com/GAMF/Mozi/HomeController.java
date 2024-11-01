package com.GAMF.Mozi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/program")
    public String ShowProgram() {
        return "program";
    }
    @GetMapping("/messages")
    public String ShowMessage() {
        return "message";
    }

    @GetMapping("/connection")
    public String ShoeConnection() {
        return "connection";
    }
    @GetMapping("/regist")
    public String ShowRegist() {
        return "registF";
    }




}

@Controller
class LoginController {
    @GetMapping("/login")
    String login() {
        return "login";
    }
}
