package org.anest.mystore.service;

import org.anest.mystore.entity.UserAddress;

import java.util.List;

public interface UserAddressService {

    UserAddress getUserDefaultAddress(List<UserAddress> userAddressList);

    UserAddress getAddressById(List<UserAddress> userAddressList, Long addressId);

    void changeDefaultAddress(List<UserAddress> userAddressList, Long addressId);
}
