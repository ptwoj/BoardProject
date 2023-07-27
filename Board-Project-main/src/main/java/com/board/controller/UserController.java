package com.board.controller;

import com.board.domain.requset.LoginRequset;
import com.board.domain.requset.SignupRequest;
import com.board.domain.response.LoginResponse;
import com.board.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/signup")
    public String getSignup() {
        return "/user/signup";
    }

    @GetMapping("/user/login")
    public String getLogin() {
        return "/user/login";
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/main";
    }

    @PostMapping("/user/signup")
    public ModelAndView signupPost(@ModelAttribute SignupRequest signupRequest, ModelAndView mv) throws Exception {
        if (userService.signup(signupRequest) != 0) {
            mv.setViewName("redirect:/user/login");
        } else {
            mv.setViewName("redirect:/user/signup");
        }
        return mv;
    }


    @PostMapping("/user/login")
    public ModelAndView loginPost(@ModelAttribute LoginRequset loginRequset, ModelAndView mv, HttpSession session) {
        LoginResponse user = (userService.login(loginRequset));
        if (user != null) {

            session.setAttribute("username", user.getUsername());
            session.setAttribute("name", user.getName());
            mv.setViewName("redirect:/main");
        } else {
            mv.setViewName("redirect:/user/login");
        }
        return mv;
    }
}
