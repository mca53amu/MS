package com.store.mobile.api.interceptor;

import java.util.Arrays;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.store.mobile.api.exception.ApiException;

/**
 * 
 * @author mohammad.miyan
 *
 */
@Component
public class ValidatorInterceptor implements HandlerInterceptor {

	private final static String ALLOWED_PATTERN = "^[a-zA-Z\\u0621-\\u064A0-9\\u0660-\\u0669&@_\\-,.: ]{0,}$";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		request.getParameterMap().forEach((parameter, values) -> {
			Arrays.stream(values).forEach(value -> { //
				if (StringUtils.isEmpty(value) && !Pattern.matches(ALLOWED_PATTERN, value)) {
					throw new ApiException(ApiFailMessage.API_VALIDATION_NOT_ALLOWED_CHARACTER);
				}
			});
		});

		return true;
	}
}