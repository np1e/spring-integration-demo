package com.hansgrohe.springintegrationdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;

public class SCPIService {

	private static Log logger = LogFactory.getLog(SCPIService.class);

	public void handleSCPIReply(ResponseEntity response) {
		logger.info(String.format("Got SCPI response: %s", response.getStatusCode()));
	}
}
