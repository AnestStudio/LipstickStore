package org.anest.mystore.service.impl;

import org.anest.mystore.entity.UserAddress;
import org.anest.mystore.service.UserAddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Override
    public UserAddress getUserDefaultAddress(List<UserAddress> userAddresses) {
        for (UserAddress userAddress : userAddresses) {
            if (userAddress.isDefaultAddress()) {
                return userAddress;
            }
        }
        return null;
    }
}
