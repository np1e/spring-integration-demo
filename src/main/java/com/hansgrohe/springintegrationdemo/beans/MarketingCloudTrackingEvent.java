package com.hansgrohe.springintegrationdemo.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketingCloudTrackingEvent {
	@JsonProperty
	private String assetName;
	@JsonProperty
	private String assetUrl;
	@JsonProperty
	private String eventType;
	@JsonProperty
	private String mimeType;

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(final String assetName) {
		this.assetName = assetName;
	}

	public String getAssetUrl() {
		return assetUrl;
	}

	public void setAssetUrl(final String assetUrl) {
		this.assetUrl = assetUrl;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(final String eventType) {
		this.eventType = eventType;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(final String mimeType) {
		this.mimeType = mimeType;
	}
}
