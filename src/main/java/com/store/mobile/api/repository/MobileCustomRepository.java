package com.store.mobile.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.store.mobile.api.entity.Mobile;

/**
 * purpose of this repository is to find mobile list of based on the properties values passed
 * @author mohammad.miyan
 *
 */
public interface MobileCustomRepository {
	public Page<Mobile> findMobileByProperties(Long id, String brand, String picture, String announceDate,
			Long priceEur, String sim, String resolution, String audioJack, String gps, String battery, Pageable page,String sortBy,String direction);
}
