package com.store.mobile.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.store.mobile.api.entity.Mobile;
import com.store.mobile.api.repository.MobileRepository;

/**
 * Purpose of this service is to fetch all mobiles based on the properties
 * 
 * @author mohammad.miyan
 *
 */
@Service
public class MobileService {
	@Autowired
	MobileRepository mobileRepository;

	public Page<Mobile> fetchMobileByProperties(Long id, String brand, String picture, String announceDate,
			Long priceEur, String sim, String resolution, String audioJack, String gps, String battery, Pageable page, String sortBy, String direction) {

		return mobileRepository.findMobileByProperties(id, brand, picture, announceDate, priceEur, sim, resolution,
				audioJack, gps, battery, page,sortBy,direction);
	}

}
