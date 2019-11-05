package com.example.products.service;

import com.example.products.entity.Users;
import com.example.products.repository.RUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("SUsers")
public class SUsers implements UserDetailsService {

    @Autowired
    @Qualifier("RUsers")
    private RUsers rUsers;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = rUsers.findByUsername(s);
        return new User(user.getUsername(), "{noop}"+user.getPassword(), createGrantedAuthorities());
    }

    protected List<GrantedAuthority> createGrantedAuthorities() {
        String[] roles = {"USER"};

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(roles[0]));

        return authorities;
    }

}
