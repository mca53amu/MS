package com.store.mobile.api.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.store.mobile.api.entity.Mobile;

/**
 * Purpose of this implementation is to return the list of all mobiles
 * @author mohammad.miyan
 *
 */
@Repository
public class MobileCustomRepositoryImpl implements MobileCustomRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	public Page<Mobile> findMobileByProperties(Long id, String brand, String picture, String announceDate,
			Long priceEur, String sim, String resolution, String audioJack, String gps, String battery, Pageable page,String sortBy,String direction) {
		Sort sort = Sort.by(Sort.Direction.fromString(direction),sortBy);
		final Query query = new Query().with(sort);
		final List<Criteria> criteria = new ArrayList<>();

		if (!StringUtils.isEmpty(id)) {
			criteria.add(Criteria.where("id").is(id));
		}

		if (!StringUtils.isEmpty(brand)) {
			criteria.add(Criteria.where("brand").regex(brand, "i"));
		}

		if (!StringUtils.isEmpty(picture)) {
			criteria.add(Criteria.where("picture").is(picture));
		}

		if (!StringUtils.isEmpty(announceDate)) {
			criteria.add(Criteria.where("release.announceDate").is(announceDate));
		}

		if (!StringUtils.isEmpty(priceEur)) {
			criteria.add(Criteria.where("release.priceEur").is(priceEur));
		}

		if (!StringUtils.isEmpty(sim)) {
			criteria.add(Criteria.where("sim").regex(".*" + sim + ".*", "i"));
		}

		if (!StringUtils.isEmpty(resolution)) {
			criteria.add(Criteria.where("resolution").is(resolution));
		}

		if (!StringUtils.isEmpty(audioJack)) {
			criteria.add(Criteria.where("hardware.audioJack").regex(audioJack, "i"));
		}

		if (!StringUtils.isEmpty(gps)) {
			criteria.add(Criteria.where("hardware.gps").regex(".*" + gps + ".*", "i"));
		}

		if (!StringUtils.isEmpty(battery)) {
			criteria.add(Criteria.where("hardware.battery").is(battery));
		}
		if (!criteria.isEmpty()) {
			query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
			long count = mongoTemplate.count(query, Mobile.class);
			List<Mobile> list = mongoTemplate.find(query.with(page), Mobile.class);
			return PageableExecutionUtils.getPage(list, page,()->count);
		} else {
			return Page.empty();
		}

	}

}
