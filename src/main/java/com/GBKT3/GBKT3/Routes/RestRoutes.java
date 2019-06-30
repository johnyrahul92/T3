package com.GBKT3.GBKT3.Routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestRoutes extends RouteBuilder {

	@Override
	public void configure() throws Exception {

//		restConfiguration().contextPath("camel").port(8080).enableCORS(true).apiContextPath("/Swagger")
//				.apiContextRouteId("swagger").contextPath("api").apiProperty("api.title", "Test REST API")
//				.apiProperty("api.version", "v1");
//
//		rest("/user").description("User API").skipBindingOnErrorCode(false).get("/{id}").to("direct:userNameValidation");

	}

}
