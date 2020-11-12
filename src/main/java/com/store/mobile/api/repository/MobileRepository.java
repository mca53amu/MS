package com.store.mobile.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.store.mobile.api.entity.Mobile;

/**
 *  Extends MongoRepository and MobileCustomRepository Interface
 * and Custome MobileRepository
 * 
 * @author mohammad.miyan
 *
 */
@Repository
public interface MobileRepository extends MongoRepository<Mobile, Long>, MobileCustomRepository {

}
