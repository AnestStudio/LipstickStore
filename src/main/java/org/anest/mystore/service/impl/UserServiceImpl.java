package org.anest.mystore.service.impl;

import org.anest.mystore.entity.AuthUser;
import org.anest.mystore.entity.Role;
import org.anest.mystore.entity.User;
import org.anest.mystore.repository.UserRepository;
import org.anest.mystore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        Set<Role> roles  = user.getRoles();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (roles != null) {
            grantedAuthorities = roles
                    .stream()
                    .map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
        }

        return new AuthUser(
                user.getUsername(),
                user.getPassword(),
                grantedAuthorities,
                user.getId(),
                user.getCreateAt(),
                user.isDeleted(),
                user.getStatus()
        );
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
