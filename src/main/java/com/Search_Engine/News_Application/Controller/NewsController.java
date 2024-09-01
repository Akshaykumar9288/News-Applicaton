package com.Search_Engine.News_Application.Controller;

import com.Search_Engine.News_Application.Repository.UserRepository;
import com.Search_Engine.News_Application.configuration.NewsApiService;
import com.Search_Engine.News_Application.model.NewsResponse;
import com.Search_Engine.News_Application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class NewsController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NewsApiService newsApiService;
    public NewsController(UserRepository userRepository, NewsApiService newsApiService){
        this.userRepository = userRepository;
        this.newsApiService = newsApiService;
    }
    @RequestMapping("/index")
    public String dashboard(Model model, Principal principal){
        String username = principal.getName();
        User user = userRepository.findByEmail(username);
        model.addAttribute("title","NEWS");
        model.addAttribute("user",user);

        try{
            NewsResponse newsResponse = newsApiService.fetchHeadlines("us");
            model.addAttribute("newsHeadlines",newsResponse.getArticles());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Dashboard/dashboard";
    }
}
