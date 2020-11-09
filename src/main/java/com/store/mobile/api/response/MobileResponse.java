package com.store.mobile.api.response;
import static com.store.mobile.api.constants.Constants.JSON_API_NUMBER_OF_PAGES_FIELD;
import static com.store.mobile.api.constants.Constants.JSON_API_NUMBER_OF_RECORDS_FIELD;
import static com.store.mobile.api.constants.Constants.JSON_API_PAGE_FIELD;
import static com.store.mobile.api.constants.Constants.JSON_API_RECORDS_FIELD;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MobileResponse<T> {
	
	@JsonProperty(value = JSON_API_PAGE_FIELD)
	private Integer page;

	@JsonProperty(value = JSON_API_NUMBER_OF_PAGES_FIELD)
	private Integer numberOfPages;

	@JsonProperty(value = JSON_API_NUMBER_OF_RECORDS_FIELD)
	private Long numberOfRecords;

	@JsonProperty(value = JSON_API_RECORDS_FIELD)
	private List<T> records;

}
