package com.nhnacademy.taskapi.project.taskapi.service;

import com.nhnacademy.taskapi.project.taskapi.domain.SignUpForm;
import com.nhnacademy.taskapi.project.taskapi.entity.Account;
import java.util.Optional;

public interface SignUpService {

    Optional<Account> doSignUp(SignUpForm signUpForm);
}
