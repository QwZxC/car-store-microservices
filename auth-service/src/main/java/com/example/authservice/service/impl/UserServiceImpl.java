package com.example.authservice.service.impl;

import com.example.authservice.domain.exception.types.UserNotFoundException;
import com.example.authservice.repository.UserRepository;
import com.example.authservice.service.UserService;
import com.example.userservice.domain.entity.User;
import com.example.userservice.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final KafkaTemplate<String, Object> createUserKafkaTemplate;

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void CreateUser(UserDto dto) {
        createUserKafkaTemplate.send(
                "userTopic",
                dto.getUuid().toString(),
                UserDto.builder()
                        .uuid(dto.getUuid())
                        .name(dto.getName())
                        .balance(dto.getBalance())
                        .username(dto.getUsername())
                        .password(dto.getPassword())
                        .registrationDate(dto.getRegistrationDate())
                        .build()
        );
    }
}
