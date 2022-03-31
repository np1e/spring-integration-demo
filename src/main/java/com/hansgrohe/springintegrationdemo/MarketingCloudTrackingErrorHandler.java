package com.hansgrohe.springintegrationdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

public class MarketingCloudTrackingErrorHandler extends DefaultResponseErrorHandler {

	private static final Logger log = LogManager.getLogger(MarketingCloudTrackingErrorHandler.class);

	@Override
	public boolean hasError(ClientHttpResponse response) {
		return hasError(response);
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		log.error("SCPI returned error with code {}", response.getStatusCode());
		if (log.isDebugEnabled()) {
			log.error(response.getBody());
		}
	}
}
