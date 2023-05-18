package com.omit.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface UserRepository extends JpaRepository<Users, Long> {
    // userid로 로그인
    Optional<Users> findByUserid(String userid);
    Optional<Users> findByEmail(String email);
}
