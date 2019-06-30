package com.GBKT3.GBKT3.Routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRoutes extends RouteBuilder {
	
	

	@Override
	public void configure() throws Exception {
		String uri = "https://testgbonline.e-gulfbank.com/T002/internet??bridgeEndpoint=true&httpClient.soTimeout=20000";
		

		from("direct:firstRoute").setHeader("CamelHttpMethod", constant("POST"))
				.setProperty("CamelCharsetName", constant("UTF-8"))
				.setHeader("Content-Type", constant("application/x-www-form-urlencoded; charset=utf-8"))
				.to("velocity://olb-login-username.vm").log("Camel body: ${body}").to(uri).convertBodyTo(String.class)
				.log("Camel body: ${body}").to("xslt://templates/xsl/olb-login-username.xsl").log("Camel body: ${body}");
		
		from("direct:testRoute").log("Camel body: ${body}");

	}
}
