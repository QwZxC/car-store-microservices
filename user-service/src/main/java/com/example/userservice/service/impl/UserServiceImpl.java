package com.example.userservice.service.impl;

import com.example.userservice.domain.entity.User;
import com.example.userservice.domain.exception.types.UserNotFoundException;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;
import com.example.userservice.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public User getByUuid(UUID uuid) {
        return userRepository.findById(uuid).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    @KafkaListener(topics = "userTopic", containerFactory = "createUserFactory")
    public void create(UserDto dto) {
        userRepository.save(
                modelMapper.map(dto, User.class)
        );
    }

    @Override
    public void deleteByUuid(UUID uuid) {
        userRepository.deleteById(uuid);
    }
}
