package com.GAMF.Mozi;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    private UsersRepository usersRepository;

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


    @GetMapping("/register")
    public String ShowRegist(Model model) {
        User user = new User();
        model.addAttribute("register", user);
        return "register_form";
    }

    //Regisztrációs form küldés
    @PostMapping("/register_send")
    public String sendRegistration(@ModelAttribute User user, BindingResult result, Model model){
        for(User user2: usersRepository.findAll())
            if(user2.getEmail().equals(user.getEmail())){
                model.addAttribute("register_message","Ezzel az e-mail címmel már létezik felhasználó");
                return "/register_error";
            }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        usersRepository.save(user);
        return "/register_success";
    }


    //Kiegészítve 11.04 TD
    @GetMapping("/connection")
    public String ShowConnection(Model model) {
        Messages messages = new Messages();
        model.addAttribute("messages", messages);
        return "connection_form";

    }

    //Kapcsolat form küldés
    @PostMapping("/send")
    public String sendMessage(@Valid @ModelAttribute Messages messages, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "connection_form";
        }
        messagesRepo.save(messages);
        return "connection_sent";

    }



}

@Controller
class LoginController {
   @GetMapping("/login")
     String login() {
        return "login";
    }
}
