package org.anest.mystore.service.impl;

import jakarta.transaction.Transactional;
import org.anest.mystore.entity.UserAddress;
import org.anest.mystore.repository.UserAddressRepository;
import org.anest.mystore.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    private final UserAddressRepository userAddressRepository;

    @Autowired
    public UserAddressServiceImpl(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }

    @Override
    public UserAddress getUserDefaultAddress(List<UserAddress> userAddressList) {
        for (UserAddress userAddress : userAddressList) {
            if (userAddress.isDefaultAddress()) {
                return userAddress;
            }
        }
        return null;
    }

    @Override
    public UserAddress getAddressById(List<UserAddress> userAddressList, Long addressId) {
        for (UserAddress userAddress : userAddressList) {
            if (Objects.equals(userAddress.getId(), addressId)) {
                return userAddress;
            }
        }
        return null;
    }

    @Override
    @Transactional
    public void changeDefaultAddress(List<UserAddress> userAddressList, Long addressId) {
        UserAddress defaultAddress = getUserDefaultAddress(userAddressList);
        defaultAddress.setDefaultAddress(false);
        userAddressRepository.save(defaultAddress);

        UserAddress newDefaultAddress = getAddressById(userAddressList, addressId);
        newDefaultAddress.setDefaultAddress(true);
        userAddressRepository.save(newDefaultAddress);
    }
}
