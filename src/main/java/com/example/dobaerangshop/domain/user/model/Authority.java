package com.example.dobaerangshop.domain.user.model;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authority")
@IdClass(Authority.class)
public class Authority implements GrantedAuthority {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    private String authority;

}
