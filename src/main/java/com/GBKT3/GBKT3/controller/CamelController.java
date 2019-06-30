package com.GBKT3.GBKT3.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class CamelController {

	@Autowired
	ProducerTemplate camelTemplate;

	@Autowired
	private CamelContext camelContext;

	@GetMapping(value = "/")
	public String startCamel() throws CamelExecutionException, JsonParseException, JsonMappingException, IOException {

		/*
		 * String url="https://testgbonline.e-gulfbank.com/T002/internet"; RestTemplate
		 * restTemplate= new RestTemplate(); MultiValueMap<String, String> map = new
		 * LinkedMultiValueMap<String, String>(); map.add("fldLoginUserId", "GT77");
		 * map.add("fldlanguage", "eng"); map.add("fldDeviceId", "01");
		 * map.add("fldLangId", "eng"); map.add("fldRequestId", "RRTFC11");
		 * map.add("fldUserType", "EN1"); map.add("fldHiddenTxnId", "TFC");
		 * map.add("vm-template", "//olb-login-username.vm");
		 * 
		 * ResponseEntity<String> respons=
		 * restTemplate.postForEntity(url,map,String.class); Exchange requestExchange =
		 * ExchangeBuilder.anExchange(camelContext).withBody(respons.getBody()).build();
		 * Exchange exchange= camelTemplate.send("direct:firstRoute", requestExchange);
		 */

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fldLoginUserId", "GT77");
		map.put("lang", "eng");
		map.put("fldDeviceId", "01");
		map.put("fldLangId", "eng");
		map.put("fldRequestId", "RRTFC11");
		map.put("fldUserType", "EN1");
		map.put("fldHiddenTxnId", "TFC");
		map.put("vm-template", "//olb-login-username.vm");

		// Future<Object> future =
		// camelTemplate.asyncRequestBodyAndHeaders("direct:firstRoute", null, map);

		camelTemplate.sendBodyAndHeaders("direct:firstRoute", null, map);

		/*
		 * Exchange requestExchange =
		 * ExchangeBuilder.anExchange(camelContext).withBody(map).build();
		 * camelTemplate.send("direct:firstRoute",requestExchange);
		 */

		return "Test";
	}
	
	@GetMapping(value = "/putCache")
	public String fileCopy() throws Exception {
		
		System.out.println("Start file processing");
		
		
		camelContext.startRoute("test2");
		
		
		return "done";
	}
}
