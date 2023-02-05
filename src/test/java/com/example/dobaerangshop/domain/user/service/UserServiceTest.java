package com.example.dobaerangshop.domain.user.service;

import com.example.dobaerangshop.domain.user.model.User;
import com.example.dobaerangshop.domain.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @DisplayName("1. [Save User]")
    @Test
    void saveUserTest(){
        User user = User.builder()
                .email("testUser@test.com")
                .password("1111")
                .enabled(true)
                .build();

        userService.saveUser(user);
    }

    @DisplayName("2. [Add Authority]")
    @Test
    void addAuthorityTest(){
        userService.addAuthority(4L, "ROLE_ADMIN");
        assertThat(userRepository.findById(4L).get().getAuthorities().size()).isEqualTo(2);
    }

    @DisplayName("3. [Deny User]")
    @Test
    void denyUserTest(){
        User user = userRepository.findById(4L).orElse(null);
        userService.denyUser(user.getUserId());
    }

}