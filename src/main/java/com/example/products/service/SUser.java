package com.example.products.service;

import com.example.products.converter.Converter;
import com.example.products.entity.User;
import com.example.products.model.MUser;
import com.example.products.repository.RRole;
import com.example.products.repository.RUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("SUser")
public class SUser implements UserDetailsService {

    @Autowired
    @Qualifier("RUser")
    private RUser rUser;

    @Autowired
    @Qualifier("RRole")
    private RRole rRole;

    @Autowired
    @Qualifier("converter")
    private Converter converter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = rUser.findByUsername(s);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), createGrantedAuthorities(user.getRoleId()));
    }

    protected List<GrantedAuthority> createGrantedAuthorities(int roleId) {
        String role = rRole.findById(roleId).getRole();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));

        return authorities;
    }

    public boolean create(User user) {
        try {
            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setRoleId(user.getRoleId());
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));
            rUser.save(newUser);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username;
            if (principal instanceof UserDetails) {
                username = ((UserDetails)principal).getUsername();
            } else {
                username = principal.toString();
            }
            User currentUser = rUser.findByUsername(username);

            User user = rUser.findById(id);

            if(currentUser.getId() != user.getId()) {
                rUser.delete(user);
            }
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public List<MUser> getUsers() {
        return converter.convertUsersList(rUser.findAll());
    }

    public User getUser(int id) {
        return rUser.findById(id);
    }

    public User getUser(String username) {
        return rUser.findByUsername(username);
    }

    public List<MUser> getAdmins() {
        return converter.convertUsersList(rUser.findByRoleId(rRole.findByRole("ADMIN").getId()));
    }

    public boolean createAdmin(User user) {
        try {
            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setRoleId(rRole.findByRole("ADMIN").getId());
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));
            rUser.save(newUser);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
