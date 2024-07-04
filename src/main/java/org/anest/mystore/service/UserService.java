package org.anest.mystore.service;

import org.anest.mystore.entity.User;

public interface UserService {

    User findByUsername(String username);

    User findByEmail(String email);

    User findByActivationCode(String activationCode);

    void save(User user, String roleName);

    void save(User user);
}
