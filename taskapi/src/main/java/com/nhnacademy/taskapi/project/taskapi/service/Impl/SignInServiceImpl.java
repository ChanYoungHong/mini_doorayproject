package com.nhnacademy.taskapi.project.taskapi.service.Impl;

import com.nhnacademy.taskapi.project.taskapi.domain.AccountIdDto;
import com.nhnacademy.taskapi.project.taskapi.entity.Account;
import com.nhnacademy.taskapi.project.taskapi.service.SignInService;

import java.util.Collections;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignInServiceImpl implements SignInService, UserDetailsService {

    private final RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        System.out.println("username " + id);

        AccountIdDto accountIdDto = new AccountIdDto(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AccountIdDto> requestEntity = new HttpEntity<>(accountIdDto, httpHeaders);

        ResponseEntity<Account> result = restTemplate.exchange("http://localhost:9090/signin"
            , HttpMethod.POST
            , requestEntity
            , Account.class
        );
        Optional<Account> account = Optional.ofNullable(result.getBody());
        log.debug("member ================================> {}", account);

        return new User(account.get().getAccountId(), account.get().getAccountPwd(),
            Collections.singletonList(new SimpleGrantedAuthority(account.get().getAccountEmail())));
    }
}
