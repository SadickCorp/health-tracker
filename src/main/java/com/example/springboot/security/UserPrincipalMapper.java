package com.example.springboot.security;

import com.example.springboot.beans.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class UserPrincipalMapper {
    public static UserPrincipal userToPrincipal(User user) {
        UserPrincipal userp = new UserPrincipal();
        List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).collect(Collectors.toList());

        userp.setUsername(user.getEmail());
        userp.setPassword(user.getPassword());
        userp.setEnabled(true);
        userp.setAuthorities(authorities);
        return userp;
    }
}
