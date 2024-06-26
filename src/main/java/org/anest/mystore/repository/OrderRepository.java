package org.anest.mystore.repository;

import org.anest.mystore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {

    @Query("SELECT o.orderStatus.id, COUNT(o) FROM Order o WHERE o.user.username = :username GROUP BY o.orderStatus.id")
    List<Object[]> countOrdersByStatusAndUsername(@Param("username") String username);
}
