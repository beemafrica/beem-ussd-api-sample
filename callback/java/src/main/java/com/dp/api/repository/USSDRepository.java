package com.dp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dp.api.entity.SmsEntity;

/**
 * USSDRepository .
 * 
 * @author admin
 *
 */
@Repository
public interface USSDRepository extends JpaRepository<SmsEntity, Integer> {

}
