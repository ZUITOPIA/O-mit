package com.omit.security;

import com.omit.domain.user.UserRepository;
import com.omit.domain.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        Users users=userRepository.findByUserid(userid).orElseThrow(
                () -> new UsernameNotFoundException("Invalid authentication")
        );
        return new CustomUserDetails(users);
    }

}

