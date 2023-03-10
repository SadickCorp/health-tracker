package com.example.springboot.security;

import com.example.springboot.beans.User;
import com.example.springboot.services.IServiceUser;
import com.example.springboot.services.ServiceUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final IServiceUser serviceUser;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.serviceUser.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
        return UserPrincipalMapper.userToPrincipal(user);
    }
}
