package com.hansgrohe.springintegrationdemo.controllers;

import com.hansgrohe.springintegrationdemo.MarketingCloudService;
import com.hansgrohe.springintegrationdemo.beans.MarketingCloudTrackingEvent;
import com.hansgrohe.springintegrationdemo.beans.Order;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/order")
public class OrderController {

	private static Log logger = LogFactory.getLog(OrderController.class);

	@Resource
	private MarketingCloudService marketingCloudService;

	@GetMapping
	public String getOrderForm(Model model) {
		model.addAttribute("orderUrl", "/order");
		model.addAttribute("order", new Order());
		return "orderForm";
	}

	@PostMapping
	public String placeOrder(@ModelAttribute("order") Order order, Model model) {

		MarketingCloudTrackingEvent event = new MarketingCloudTrackingEvent();
		event.setEventType("WEBSITE_INFO_ORDER");
		marketingCloudService.track(event);
		logger.info("Placed order");

		model.addAttribute("message", "Successfully placed order");
		return "orderForm";
	}
}
