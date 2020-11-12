package com.store.mobile.api.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "MOBILE")
public class Mobile {
	@Id
	private Long id;
	private String brand;
	private String picture;
	private Release release;
	private String sim;
	private String resolution;
	private Hardware hardware;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class Hardware {
	private String audioJack;
	private String gps;
	private String battery;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
 class Release {
	private String announceDate;
	private Double priceEur;
}