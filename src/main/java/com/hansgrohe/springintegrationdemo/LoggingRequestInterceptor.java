package com.hansgrohe.springintegrationdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class LoggingRequestInterceptor implements ClientHttpRequestInterceptor {
	final static Logger log = LoggerFactory.getLogger(LoggingRequestInterceptor.class);

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
		traceRequest(request, body);
		ClientHttpResponse response = execution.execute(request, body);
		traceResponse(response);
		return response;
	}

	private void traceRequest(HttpRequest request, byte[] body) throws IOException {
		log.info("===========================request begin================================================");
		log.debug("URI         : {}", request.getURI());
		log.debug("Method      : {}", request.getMethod());
		log.debug("Headers     : {}", request.getHeaders() );
		log.debug("Request body: {}", new String(body, "UTF-8"));
		log.info("==========================request end================================================");
	}

	private void traceResponse(ClientHttpResponse response) throws IOException {
		log.info("============================response begin==========================================");
		log.debug("Status code  : {}", response.getStatusCode());
		log.debug("Status text  : {}", response.getStatusText());
		log.debug("Headers      : {}", response.getHeaders());
		log.debug("Response body: {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
		log.info("=======================response end=================================================");
	}
}
