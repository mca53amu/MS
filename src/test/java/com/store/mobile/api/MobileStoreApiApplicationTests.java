package com.store.mobile.api;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;

import com.store.mobile.api.interceptor.ApiFailMessage;
/**
 * 
 * @author mohammad.miyan
 *
 */
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class MobileStoreApiApplicationTests {
	@Autowired
	private MockMvc mvc;

	@Test
	public void shouldGetOk() throws Exception {
		LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		mvc.perform(get("/mobile/search").params(requestParams)).andExpect(status().isOk());

	}

	@Test
	public void shouldGet10() throws Exception {
		LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		requestParams.add("priceEur", "200");
		mvc.perform(get("/mobile/search").params(requestParams)).andExpect(status().isOk())
				.andExpect(jsonPath("$.totalRecords", is(10)));

	}

	@Test
	public void shouldGet18() throws Exception {
		LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		requestParams.add("sim", "eSim");
		mvc.perform(get("/mobile/search").params(requestParams)).andExpect(status().isOk())
		.andExpect(jsonPath("$.totalRecords", is(18)));

	}

	@Test
	public void shouldGet2() throws Exception {
		LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		requestParams.add("priceEur", "200");
		requestParams.add("announceDate", "1999");
		mvc.perform(get("/mobile/search").params(requestParams)).andExpect(status().isOk())
		.andExpect(jsonPath("$.totalRecords", is(2)));

	}
	
	@Test
	public void shouldReturnErrorCode() throws Exception {
		LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		requestParams.add("sim", "eSim$");
		mvc.perform(get("/mobile/search").params(requestParams)).andExpect(status().isInternalServerError())
		.andExpect(jsonPath("$.errorCode",is(ApiFailMessage.API_VALIDATION_NOT_ALLOWED_CHARACTER)));

	}


}
