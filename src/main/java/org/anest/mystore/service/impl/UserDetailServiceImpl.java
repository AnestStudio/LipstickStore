package org.anest.mystore.service.impl;

import org.anest.mystore.entity.UserDetail;
import org.anest.mystore.repository.UserDetailRepository;
import org.anest.mystore.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    private final UserDetailRepository userDetailRepository;

    @Autowired
    public UserDetailServiceImpl(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public UserDetail findByMobile(String mobile) {
        return userDetailRepository.findByMobile(mobile);
    }
}
