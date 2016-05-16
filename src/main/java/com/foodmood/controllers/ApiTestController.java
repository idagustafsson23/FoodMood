package com.foodmood.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.foodmood.api.APIManager;

@Controller
public class ApiTestController {
		
	@RequestMapping(value="/apitest/{id:[\\d]+}", method = RequestMethod.GET)
	@ResponseBody
	public String getAPIData(@PathVariable("id") Long id) {	
		APIManager apiManager = new APIManager("http://www.systembolaget.se/api/assortment/products/xml");
	    apiManager.initializeConnection();
	    
	    
	    Map<String, String> map = apiManager.getMapFromArticleNumber(id.toString());
	    List<String> keys = new ArrayList<String>(map.keySet());
	    for (String key: keys) {
	        System.out.println(key + ": " + map.get(key));
	    }
	    String nr = map.get("nr");
	    String namn2 = map.get("Namn2");
	    String typ = map.get("Typ");
	    
	    return nr + " " + namn2 + "" + typ;
	}
	
}
