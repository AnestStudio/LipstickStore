package org.anest.mystore.service;

import org.anest.mystore.entity.UserAddress;

import java.util.List;

public interface UserAddressService {

    UserAddress getUserDefaultAddress(List<UserAddress> userAddresses);
}
