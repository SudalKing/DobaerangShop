package com.example.dobaerangshop.domain.user.service;

import com.example.dobaerangshop.domain.user.model.Authority;
import com.example.dobaerangshop.domain.user.model.User;
import com.example.dobaerangshop.domain.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException(username));
    }

    public void saveUser (User user){
        String encodedPass = passwordEncoder.encode(user.getPassword());
        User setUser = User.builder()
                .email(user.getEmail())
                .password(encodedPass)
                .enabled(true)
                .build();

        userRepository.save(setUser);

        addAuthority(setUser.getUserId(), "ROLE_USER");
    }

    public void addAuthority(Long userId, String role){
        userRepository.findById(userId).ifPresent(user -> {
            Authority authority = new Authority(user.getUserId(), role);

            if(user.getAuthorities() == null){
                HashSet<Authority> authorities = new HashSet<>();
                authorities.add(authority);
                user.setAuthorities(authorities);

                userRepository.save(user);

            } else if(!user.getAuthorities().contains(authority)){
                HashSet<Authority> authorities = new HashSet<>();
                authorities.addAll(user.getAuthorities());
                authorities.add(authority);
                user.setAuthorities(authorities);

                userRepository.save(user);
            }
        });
    }

    public void denyUser(Long userId){
        userRepository.findById(userId).ifPresent(user -> {
            user.setEnabled(false);
            userRepository.save(user);
        });
    }

}
