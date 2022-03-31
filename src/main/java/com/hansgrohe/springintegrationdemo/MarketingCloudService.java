package com.hansgrohe.springintegrationdemo;

import com.hansgrohe.springintegrationdemo.beans.MarketingCloudTrackingEvent;

public interface MarketingCloudService {

	void track(MarketingCloudTrackingEvent event);
}
