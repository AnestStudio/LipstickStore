package org.anest.mystore.service;

import org.anest.mystore.entity.User;

public interface UserService {

    User findByUsername(String username);
}
