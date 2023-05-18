package com.omit.service;

import com.omit.domain.Authority;
import com.omit.domain.user.UserRepository;
import com.omit.domain.user.Users;
import com.omit.dto.LoginRequestDto;
import com.omit.dto.LoginResponseDto;
import com.omit.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public LoginResponseDto login(LoginRequestDto requestDto) throws Exception{
        Users users=userRepository.findByUserid(requestDto.getUserid()).orElseThrow(() ->
                new BadCredentialsException("잘못된 계정정보입니다."));

        if(!passwordEncoder.matches(requestDto.getPassword(), users.getPassword())){
            throw new BadCredentialsException("잘못된 계정정보입니다.");
        }

        return LoginResponseDto.builder()
                .id(users.getId())
                .userid(users.getUserid())
                .username(users.getUsername())
                .email(users.getEmail())
                .roles(users.getRoles())
                .token(jwtProvider.createToken(users.getUserid(), users.getRoles()))
                .build();
    }

    public boolean register(LoginRequestDto requestDto) throws Exception{
        try {
            userRepository.findByUserid(requestDto.getUserid())
                    .ifPresent(m->{
                        throw new IllegalStateException("이미 존재하는 아이디 입니다.");
                    });
            userRepository.findByEmail(requestDto.getEmail())
                    .ifPresent(m->{
                        throw new IllegalStateException("이미 존재하는 이메일 입니다.");
                    });

            Users users= Users.builder()
                    .id(requestDto.getId())
                    .userid(requestDto.getUserid())
                    .password(passwordEncoder.encode(requestDto.getPassword()))
                    .username(requestDto.getUsername())
                    .email(requestDto.getEmail())
                    .build();

            users.setRoles(Collections.singletonList(Authority.builder().name("ROLE_USER").build()));

            userRepository.save(users);
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("잘못된 요청입니다.");
        }
        return true;

    }

    public LoginResponseDto getUsers(String userid) throws Exception{
        Users users=userRepository.findByUserid(userid)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));
        return new LoginResponseDto(users);
    }

}
