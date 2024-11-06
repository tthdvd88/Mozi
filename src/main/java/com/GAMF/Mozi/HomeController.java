package com.GAMF.Mozi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    //Message repo létrehozása a controllerben
    @Autowired
    private MessagesRepo messagesRepo;

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }



    @GetMapping("/program")
    public String ShowProgram() {
        return "program";
    }


    @GetMapping("/messages")
    public String ShowMessage(Model model) {
        model.addAttribute("messages",messagesRepo.findAll());
        return "message";
    }

    //Kiegészítve 11.04 TD
    @GetMapping("/connection")
    public String ShowConnection(Model model) {
        Messages messages = new Messages();
        model.addAttribute("messages", messages);
        return "connection_form";

    }
    @GetMapping("/regist")
    public String ShowRegist() {
        return "registF";
    }


    //Kapcsolat form küldés
    @PostMapping("/send")
    public String sendMessage(@ModelAttribute Messages messages, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "contact_form";
        }
        messagesRepo.save(messages);
        return "contact_send";

    }



}

@Controller
class LoginController {
   @GetMapping("/login")
     String login() {
        return "login";
    }
}
