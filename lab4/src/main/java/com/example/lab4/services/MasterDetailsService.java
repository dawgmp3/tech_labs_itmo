package com.example.lab4.services;

import com.example.lab4.entities.Master;
import com.example.lab4.repos.MasterRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MasterDetailsService implements UserDetailsService {
    @Autowired
    private MasterRepos masterRepos;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Master user= masterRepos.findMasterByLogin(userName);
        if (user == null) {
            throw new UsernameNotFoundException("No user found: "+userName);
        }
        UserDetails userDetails = User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles(String.valueOf(user.getRole()))
                .build();
        return userDetails;
    }
}