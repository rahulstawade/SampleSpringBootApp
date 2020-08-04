package com.rahul.practice.FirstSpringBootProject.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Value("${app.version}")
	private String appVersion;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public Map getVersion() {

		Map map = new HashMap<String, String>();
		map.put("App-Version", appVersion);
		
		return map;
	}
}
