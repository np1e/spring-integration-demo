package com.hansgrohe.springintegrationdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.mapping.HeaderMapper;
import org.springframework.messaging.MessageHeaders;

import java.util.Map;

public class SCPIAuthorizationHeaderMapper implements HeaderMapper {

	@Value("${scpi.auth.username")
	private String scpiUsername;

	@Value("${scpi.auth.password}")
	private String scpiPassword;

	@Override
	public void fromHeaders(final MessageHeaders headers, final Object target) {

	}

	@Override
	public Map<String, Object> toHeaders(final Object source) {
		return null;
	}
}
