package com.example.springboot.services;

import com.example.springboot.beans.User;
import com.example.springboot.dto.light.LightUserDto;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IServiceUser {
    public User addUser(final User user);
    public User getUserById(final long id);
    public User updateUser(Long id, LightUserDto dto);
    public void deleteUser(final long id);

    public Optional<User> findByEmail(final String email);

}
