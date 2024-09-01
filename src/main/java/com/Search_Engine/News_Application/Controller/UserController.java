package com.Search_Engine.News_Application.Controller;

import com.Search_Engine.News_Application.Repository.UserRepository;
import com.Search_Engine.News_Application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    //This is Home page
    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("title","Home-News Portal");
        return "home";
    }

    //This is Sign-up page
    @RequestMapping("/signup")
    public String signup(Model model){
        model.addAttribute("title","Signup-News Portal");
        return "signup";
    }

    //This is about page
    @RequestMapping("/about")
    public String about(Model model){
            model.addAttribute("title", "About-News Portal");
            return "about";
    }

    //This is Sign-in page
    @RequestMapping("/signin")
    public String singnin(Model model){
            model.addAttribute("title", "Signin-News Portal");
            return "signin";
    }

    @PostMapping("/do_register")
    public String register(@Valid @ModelAttribute("user") User user,BindingResult result, Model model, RedirectAttributes redirectAttributes){

           if (result.hasErrors()){
           System.out.println("ERROR "+result.toString());
             model.addAttribute("user",user);
            return "signup";
           }
            user.setRole("ROLE_USER");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            model.addAttribute("title", "Register-Successfully");

        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            // Email already exists, return to signup page with error message
            model.addAttribute("user",user);
            model.addAttribute("error", "User already exists");
            return "signup";
        }
            User result1 = this.userRepository.save(user);
            if (result1 != null) {
               redirectAttributes.addFlashAttribute("message", "Register Successful");
            }else {
               redirectAttributes.addFlashAttribute("message","Something went wrong, please enter correct details or check your internet connection");
            }
            return "redirect:/signup";
    }

}
