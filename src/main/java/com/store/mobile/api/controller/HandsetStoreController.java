package com.store.mobile.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.mobile.api.entity.Mobile;
import com.store.mobile.api.enums.SortBy;
import com.store.mobile.api.response.MobileResponse;
import com.store.mobile.api.service.MobileService;

@RestController
public class HandsetStoreController {
	@Autowired
	MobileService mobileService;

	/**
	 * Filter Mobile list based on the request parameters
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param id
	 * @param brand
	 * @param picture
	 * @param announceDate
	 * @param priceEur
	 * @param sim
	 * @param resolution
	 * @param audioJack
	 * @param gps
	 * @param battery
	 * @return List of Mobiles
	 */
	@GetMapping("/mobile/search")
	public MobileResponse<Mobile> mobileSearch(@RequestParam(required = false, defaultValue = "1") int currentPage, //
			@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(value = "sortBy", required = false, defaultValue = "ID") SortBy sortColumn, //
			@RequestParam(value = "sortDirection", required = false, defaultValue = "ASC") String sortDirection, //
			@RequestParam(required = false) Long id,
			@RequestParam(required = false) String brand, @RequestParam(required = false) String picture,
			@RequestParam(required = false) String announceDate, @RequestParam(required = false) Long priceEur,
			@RequestParam(required = false) String sim, @RequestParam(required = false) String resolution,
			@RequestParam(required = false) String audioJack, @RequestParam(required = false) String gps,
			@RequestParam(required = false) String battery) {
		
		PageRequest pageable = PageRequest.of(currentPage-1, pageSize);
		Page<Mobile> page = mobileService.fetchMobileByProperties(id, brand, picture, announceDate, priceEur, sim,
				resolution, audioJack, gps, battery, pageable, sortColumn.property,sortDirection);
		List<Mobile> content = page.getContent();
		long totalElements = page.getTotalElements();
		int totalPages = page.getTotalPages();
		return new MobileResponse<Mobile>(currentPage,totalPages,totalElements,content);
	}

}
