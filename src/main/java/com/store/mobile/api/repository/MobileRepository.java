package com.store.mobile.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.store.mobile.api.entity.Mobile;

/**
 * Purpose of this repository is provide all the operations of MongoRepository
 * and Custome MobileRepository
 * 
 * @author mohammad.miyan
 *
 */
@Repository
public interface MobileRepository extends MongoRepository<Mobile, Long>, MobileCustomRepository {

}
