package com.omit.security;

import com.omit.domain.user.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private final Users users;

    public CustomUserDetails(Users users){
        this.users=users;
    }

    public final Users getUsers(){
        return users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return users.getRoles().stream()
                .map(o-> new SimpleGrantedAuthority(o.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword(){
        return users.getPassword();
    }

    //PK
    @Override
    public String getUsername(){
        return users.getUserid();
    }

    //계정 만료 여부
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    //계정 잠김 여부
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    //비밀번호 만료 여부
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    //계정 활성화 설정
    @Override
    public boolean isEnabled(){
        return true;
    }
}
