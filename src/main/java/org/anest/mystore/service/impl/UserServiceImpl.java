package org.anest.mystore.service.impl;

import org.anest.mystore.entity.AuthUser;
import org.anest.mystore.entity.Role;
import org.anest.mystore.entity.User;
import org.anest.mystore.repository.RoleRepository;
import org.anest.mystore.repository.UserRepository;
import org.anest.mystore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DisabledException {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("ERROR: user not found");
            throw new UsernameNotFoundException(username);
        }

        if (!user.isEnabled()) {
            System.out.println("ERROR: not enabled");
            throw new DisabledException("User account is not enabled");
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
                user.getStatus(),
                user.isEnabled(),
                user.getActivationCode()
        );
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByActivationCode(String activationCode) {
        return userRepository.findByActivationCode(activationCode);
    }

    @Override
    public void save(User user, String roleName) {
        Role userRole = roleRepository.findByRoleName(roleName);
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
