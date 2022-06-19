package com.example.lab4.services;

import com.example.lab4.entities.Master;
import com.example.lab4.repos.MasterRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class MasterAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private MasterRepos masterRepos;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        Master master = masterRepos.findMasterByLogin(login);
        if (master == null) {
            throw new BadCredentialsException("No user found"+login);
        }
        if (!password.equals(master.getPassword())) {
            throw new BadCredentialsException("Incorrect password");
        }
        UserDetails principal = User.builder()
                .username(master.getLogin())
                .password(master.getPassword())
                .roles(String.valueOf(master.getRole()))
                .build();
        return new UsernamePasswordAuthenticationToken(
                principal, password, principal.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}