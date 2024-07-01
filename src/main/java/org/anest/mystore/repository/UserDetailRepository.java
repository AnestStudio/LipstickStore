package org.anest.mystore.repository;

import org.anest.mystore.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {

    UserDetail findByMobile(String mobile);
}
