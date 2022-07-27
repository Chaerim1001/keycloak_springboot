package com.example.security;

import com.example.entity.Roles;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // ./SpringSecurityConfig에   .usernameParameter("username")로 설정해주었기 때문에 로그인 페이지에서 입력한 username값은 이 메소드 파라미터로 들어온다.
        User user = userService.getUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        for(Roles role: user.getRoles()){
            authorities.add(new SimpleGrantedAuthority((role.getRole())));
        }

        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(), authorities);
    }
}

