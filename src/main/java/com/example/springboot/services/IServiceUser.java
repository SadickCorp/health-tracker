package com.example.springboot.services;

import com.example.springboot.beans.User;
import com.example.springboot.dto.light.LightUserDto;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

public interface IServiceUser {
    public User addUser(final User user);
    public User getUserById(final UUID id);
    public User updateUser(UUID id, LightUserDto dto);
    public void deleteUser(final UUID id);

    public Optional<User> findByEmail(final String email);

}
