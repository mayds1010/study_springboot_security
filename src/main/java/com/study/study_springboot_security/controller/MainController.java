package com.study.study_springboot_security.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping({ "/" }) // 관리자,일반사용자 접속가능
    public ModelAndView main(ModelAndView modelAndView) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) { // 로그인이 되어 있을땐 UserDetails
            String username = ((UserDetails) principal).getUsername();
        } else {
            String username = principal.toString(); // 로그인 안되어 있음 toString
        }

        String viewName = "/WEB-INF/views/main.jsp";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    // getAuthorities = map
    @GetMapping({ "/admin" }) // 관리자가 접속하는 곳
    public ModelAndView admin(ModelAndView modelAndView) {
        String viewName = "/WEB-INF/views/admin.jsp";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
}
