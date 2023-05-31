package com.example.springboot.services;

import com.example.springboot.beans.User;
import com.example.springboot.dto.light.LightUserDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceUserTest {

    @Autowired
    private ServiceUser userService;

    private final String username = "emailtest@junit5.m2i";
    private final String password = "test123478moi";
    private final String passwordChanged = "password9875";

    @Test
    @Order(1)
    void addUserTest(){
        User user = new User();
        user.setEmail(username);
        user.setPassword(password);
        User userAdded = this.userService.addUser(user);
        assertNotNull(userAdded);
        assertEquals(userAdded.getEmail(), username);
        assertEquals(userAdded.getPassword(), password);
    }

    @Test
    @Order(2)
    void updateUserTest(){
        User user = this.userService.findByEmail(username).orElse(null);
        assertNotNull(user);
        LightUserDto dto = new LightUserDto();
        dto.setEmail(username);
        dto.setPassword(passwordChanged);
        User userUpdated = this.userService.updateUser(user.getId(),dto);
        assertNotNull(userUpdated);
        assertEquals(userUpdated.getEmail(), username);
        assertNotEquals(userUpdated.getPassword(), password);
    }

    @Test
    @Order(3)
    void getUserByIdTest(){
        User user = this.userService.findByEmail(username).orElse(null);
        assertNotNull(user);
        User userById = this.userService.getUserById(user.getId());
        assertNotNull(userById);
        assertEquals(userById.getEmail(), username);
    }

    @Test
    @Order(4)
    void deleteUserTest(){
        User user = this.userService.findByEmail(username).orElse(null);
        assertNotNull(user);
        this.userService.deleteUser(user.getId());
        User userById = this.userService.getUserById(user.getId());
        assertNull(userById);
    }

}
