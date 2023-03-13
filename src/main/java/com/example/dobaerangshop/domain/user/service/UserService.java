package com.example.dobaerangshop.domain.user.service;

import com.example.dobaerangshop.domain.user.dto.UserDto;
import com.example.dobaerangshop.domain.user.model.Address;
import com.example.dobaerangshop.domain.user.model.Authority;
import com.example.dobaerangshop.domain.user.model.User;
import com.example.dobaerangshop.domain.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
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

    /**
     * 회원가입 - user 권한 저장
     */
    public void saveUser (UserDto userDto){
        duplicateVerification(userDto);

        Address address = Address.builder()
                .city(userDto.getCity())
                .street(userDto.getStreet())
                .zipcode(userDto.getZipcode())
                .build();

        String encodedPass = passwordEncoder.encode(userDto.getPassword());
        User setUser = User.builder()
                .email(userDto.getEmail())
                .password(encodedPass)
                .address(address)
                .enabled(true)
                .build();

        userRepository.save(setUser);

        addAuthority(setUser.getId(), "ROLE_USER");
    }

    public void addAuthority(Long userId, String role){
        userRepository.findById(userId).ifPresent(user -> {
            Authority authority = new Authority(user.getId(), role);

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

    /**
     * 모든 User 조회
     */
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    /**
     * 회원 중복 검증
     */
    public void duplicateVerification(UserDto userDto){
        Optional<User> users = userRepository.findUserByEmail(userDto.getEmail());

        if(users.isPresent()){
            throw new IllegalStateException("이미 존재하는 Email입니다.");
        }
    }

}
