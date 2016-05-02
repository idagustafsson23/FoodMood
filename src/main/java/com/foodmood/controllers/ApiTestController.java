package com.foodmood.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiTestController {
		
	@RequestMapping
	@ResponseBody
	public void createApiReader() {
		ApiManager apiManager = new ApiManager();
	}
}
