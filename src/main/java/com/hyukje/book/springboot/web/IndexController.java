package com.hyukje.book.springboot.web;


import com.hyukje.book.springboot.config.oauth.LoginUser;
import com.hyukje.book.springboot.config.oauth.dto.SessionUser;
import com.hyukje.book.springboot.domain.user.User;
import com.hyukje.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());


        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }
}
