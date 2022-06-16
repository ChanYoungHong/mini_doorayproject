package com.nhnacademy.taskapi.project.taskapi.controller;

import com.nhnacademy.taskapi.project.taskapi.domain.SignUpForm;
import com.nhnacademy.taskapi.project.taskapi.service.SignUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequiredArgsConstructor
@EnableWebMvc
@Slf4j

public class SignUpController {

    private final SignUpService signUpService;

    @GetMapping("/signup")
    public String signUpPage() {
        return "/signUpForm.html";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccessPage() {
        return "/loginSuccess.html";
    }

    @PostMapping("/singup")
    public String signUpService(SignUpForm signUpForm) {
        log.debug("member가 들어갔는지??? =============> {}", signUpService.doSignUp(signUpForm));

        return "/loginSuccess";
    }

}
