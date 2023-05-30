package com.example.springboot.controllers;

import com.example.springboot.beans.User;
import com.example.springboot.dto.JwtResponse;
import com.example.springboot.dto.LoginDTO;
import com.example.springboot.dto.UserDto;
import com.example.springboot.dto.light.LightUserDto;
import com.example.springboot.mappers.UserMapper;
import com.example.springboot.security.JwtProvider;
import com.example.springboot.services.ServiceUser;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    AuthenticationManager authenticationManager;
    ServiceUser serviceUser;
    JwtProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginDTO login) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> createUser(@RequestBody LightUserDto lightUserDto){
        User user = UserMapper.INSTANCE.toBo(lightUserDto);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //TODO ajouter le role
        user = this.serviceUser.addUser(user);
        UserDto userDto = UserMapper.INSTANCE.toDto(user);
        return ResponseEntity.ok(userDto);
    }

}
