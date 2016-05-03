package com.foodmood.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.foodmood.api.APIManager;

@Controller
public class ApiTestController {
		
	@RequestMapping(value="/apitest", method = RequestMethod.GET)
	@ResponseBody
	public String getAPIData() {	
		APIManager apiManager = new APIManager("http://www.systembolaget.se/api/assortment/products/xml");
	    apiManager.initializeConnection();
	    String getData = apiManager.readXMLData();
	    return "";
	}
	
}
