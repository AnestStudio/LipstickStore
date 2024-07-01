package org.anest.mystore.service;

import org.anest.mystore.entity.UserDetail;

public interface UserDetailService {

    UserDetail findByMobile(String mobile);
}
