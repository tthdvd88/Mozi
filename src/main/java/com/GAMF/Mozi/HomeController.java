package com.GAMF.Mozi;

import jakarta.validation.Valid;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {


    @Autowired
    private MessagesRepo messagesRepo;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private MoziRepo moziRepo;
    @Autowired
    private FilmRepo filmRepo;
    @Autowired
    private HelyRepo helyRepo;


    @GetMapping("/")
    public String getIndex() {
        return "index";
    }



    @GetMapping("/program")
    public String ShowProgram(Model model) {
        model.addAttribute("mozi", moziRepo.findAll());
        return "program";
    }


    @GetMapping("/messages")
    public String ShowMessage(Model model) {
        model.addAttribute("messages",messagesRepo.findAll());
        model.addAttribute("users",usersRepository.findAll());
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
    public String sendRegistration(@Valid @ModelAttribute User user, BindingResult result, Model model){
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
            return "contact_form";
        }
        messagesRepo.save(messages);
        return "connection_sent";

    }

    //Moziműsora az adott mozinak a program oldalról ideérve
    @GetMapping("/mozimusor/{moziazon}")
    public String ShowMozimusor(@PathVariable(name="moziazon") int moziazon, Model model){
        model.addAttribute("mozi",moziRepo.findById(moziazon));
        model.addAttribute("mozinev",moziRepo.findById(moziazon).get().getMozinev());
       return "/mozimusor";
    }

    //@GetMapping("/mozimusor/{moziazon}/filmek")
    //public ResponseEntity<List<Film>> getFilmById(@PathVariable(value="fkod") long fkod) {
    //    List<Film> filmek = filmRepo.findMoziByFkod(fkod);
    //    return new ResponseEntity<>(filmek,HttpStatus.OK);
    //}


    //String A() {
    //    String adottFilm = "";
    //    for (Mozi mozi : moziRepo.findAll()) {
    //        adottFilm = mozi.getMozinev();
    //    }
    //    return adottFilm;
    //}








}

@Controller
class LoginController {
   @GetMapping("/login")
     String login() {
        return "login";
    }
}
