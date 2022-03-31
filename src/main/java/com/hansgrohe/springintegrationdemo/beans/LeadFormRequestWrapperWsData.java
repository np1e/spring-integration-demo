package com.hansgrohe.springintegrationdemo.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LeadFormRequestWrapperWsData {

	@JsonProperty("Contact")
	LeadFormRequestWsData leadFormRequestWsData;

	public LeadFormRequestWsData getLeadFormRequestWsData() {
		return leadFormRequestWsData;
	}

	public void setLeadFormRequestWsData(LeadFormRequestWsData leadFormRequestWsData) {
		this.leadFormRequestWsData = leadFormRequestWsData;
	}
}
