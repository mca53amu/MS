package com.store.mobile.api.filter;

import java.time.Instant;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import com.store.mobile.api.constants.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(1)
public class RequestLoggingFilter extends AbstractRequestLoggingFilter {
	@Override
	protected void beforeRequest(HttpServletRequest request, String message) {
		Instant now = Instant.now();
		long startTime = now.toEpochMilli();
		UUID logRefId = UUID.randomUUID();
		request.setAttribute(Constants.REQUEST_START_TIME, startTime);
		request.setAttribute(Constants.LOG_REFERENCE_ID, logRefId);

		logger.info(String.format(Constants.LOG_REFERENCE_ID + "{%s} Request URL {%s} Start Time {%s}", logRefId,
				request.getRequestURL(), now));

	}

	@Override
	protected void afterRequest(HttpServletRequest request, String message) {
		Instant now = Instant.now();
		long startTime = (Long) request.getAttribute(Constants.REQUEST_START_TIME);
		UUID logRefId = (UUID) request.getAttribute(Constants.LOG_REFERENCE_ID);
		long endTime = now.toEpochMilli();
		logger.info(String.format(Constants.LOG_REFERENCE_ID + "{%s} Request URL {%s} Time Taken {%s} ms", logRefId,
				request.getRequestURL(), endTime - startTime));
	}

}
