package org.anest.mystore.repository;

import org.anest.mystore.entity.CommonValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonValueRepository extends JpaRepository<CommonValue, Long> {

    List<CommonValue> findByType(String type);
}
