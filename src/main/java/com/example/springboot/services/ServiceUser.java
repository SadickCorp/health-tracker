package com.example.springboot.services;

import com.example.springboot.beans.User;
import com.example.springboot.dto.light.LightUserDto;
import com.example.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service()
@RequiredArgsConstructor
public class ServiceUser implements IServiceUser {
    private final UserRepository userRepository;
    @Override
    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User getUserById(UUID id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(UUID id, LightUserDto dto) {
        User user = this.getUserById(id);
        user.update(dto);
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }
}
