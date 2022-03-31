package com.hansgrohe.springintegrationdemo;

import com.hansgrohe.springintegrationdemo.beans.MarketingCloudTrackingEvent;
import com.hansgrohe.springintegrationdemo.beans.LeadFormRequestWrapperWsData;
import com.hansgrohe.springintegrationdemo.beans.LeadFormRequestWsData;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MCTrackingEvenTransformer {

	private static Log logger = LogFactory.getLog(MCTrackingEvenTransformer.class);

	@Value("${scpi.auth.username}")
	private String scpi_username;
	@Value("${scpi.auth.password}")
	private String scpi_password;

	public Message<LeadFormRequestWrapperWsData> convertEventToRequest(MarketingCloudTrackingEvent event) {
		logger.info("Transforming MC Event");
		LeadFormRequestWrapperWsData request = new LeadFormRequestWrapperWsData();
		LeadFormRequestWsData requestData = new LeadFormRequestWsData();

		requestData.setSourceId(RandomStringUtils.randomAlphanumeric(16).toUpperCase());
		requestData.setContactID("dummy_hps_user_installer@hansgrohe.com");
		requestData.setEmail("dummy_hps_user_installer@hansgrohe.com");
		requestData.setContactOrigin("HPS");

		Map<String, Object> interactions = new HashMap<>();
		interactions.put("CommunicationMedium", "WEB");
		interactions.put("InteractionType", event.getEventType());
		if (StringUtils.isNotEmpty(event.getAssetName())) {
			interactions.put("InteractionContent", event.getAssetName());
			interactions.put("InteractionDigitalAssets", Map.of(
					"DigitalAssetName", event.getAssetName(),
					"DigitalAssetURL", event.getAssetUrl(),
					"DigitalAssetMimeType", event.getMimeType()
			));
		}
		requestData.setInteractions(interactions);
		request.setLeadFormRequestWsData(requestData);
		return MessageBuilder.withPayload(request)
				.setHeader("Authorization", createHttpAuthHeader())
				.build();
	}

	public String createHttpAuthHeader() {
		String auth = this.scpi_username + ":" + this.scpi_password;

		HttpHeaders headers = new HttpHeaders();
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.US_ASCII));
		return String.format("Basic %s", new String(encodedAuth));
	}
}
