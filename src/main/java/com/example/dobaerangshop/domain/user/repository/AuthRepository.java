package com.example.dobaerangshop.domain.user.repository;

import com.example.dobaerangshop.domain.user.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Authority, Long> {
}
