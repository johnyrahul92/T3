package com.GBKT3.GBKT3.Routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.ehcache.EhcacheConstants;
import org.springframework.stereotype.Component;

@Component
public class CacheRotues extends RouteBuilder  {
	
	private static final String EHCACHE_ENDPOINT="ehcache://dataServiceCache?configurationUri=ehcache.xml&keyType=java.lang.Long&valueType=java.io.Serializable";
	
	private static final String PROFILE_CACHE_ENDPOINT="ehcache://UserProfiles?configurationUri=ehcache.xml&keyType=java.lang.String&valueType=java.io.Serializable";
	
	
	private static final String OLBSESSIONS_CACHE_ENDPOINT="ehcache://OlbSessions?configurationUri=ehcache.xml&keyType=java.lang.String&valueType=java.io.Serializable";

	
	@Override
	public void configure() throws Exception {	
		
		
		from("direct:putProfileCacheData").routeId("profilePut")
		.log("body to ProfileCachePut  : ${body}")		
		.setHeader(EhcacheConstants.ACTION, constant(EhcacheConstants.ACTION_PUT))
        .setHeader(EhcacheConstants.KEY, header("uniqueId").convertTo(String.class))
        .to(PROFILE_CACHE_ENDPOINT);
		
		
		
		from("direct:getProfileCacheData").routeId("profileGet")
		.log("body to ProfileCacheGet  : ${body}")		
		.setHeader(EhcacheConstants.ACTION, constant(EhcacheConstants.ACTION_GET))
        .setHeader(EhcacheConstants.KEY, header("uniqueId").convertTo(String.class))
        .to(PROFILE_CACHE_ENDPOINT);
		
		from("direct:deleteProfileCacheData").routeId("profileRemove")
		.log("body to ProfileCacheRemove  : ${body}")		
		.setHeader(EhcacheConstants.ACTION, constant(EhcacheConstants.ACTION_REMOVE))
        .setHeader(EhcacheConstants.KEY, header("uniqueId").convertTo(String.class))
        .to(PROFILE_CACHE_ENDPOINT);
		
		
		from("direct:putOlbSessionsCacheData").routeId("OlbSessionsPut")
		.log("body to OlbSessionsCachePut  : ${body}")		
		.setHeader(EhcacheConstants.ACTION, constant(EhcacheConstants.ACTION_PUT))
        .setHeader(EhcacheConstants.KEY, header("uniqueId").convertTo(String.class))
        .to(OLBSESSIONS_CACHE_ENDPOINT);
		
		
		from("direct:getOlbSessionsCacheData").routeId("OlbSessionsGet")
		.log("body to OlbSessionsGet  : ${body}")		
		.setHeader(EhcacheConstants.ACTION, constant(EhcacheConstants.ACTION_GET))
        .setHeader(EhcacheConstants.KEY, header("uniqueId").convertTo(String.class))
        .to(OLBSESSIONS_CACHE_ENDPOINT);
		
		from("direct:deleteOlbSessionsCacheData").routeId("OlbSessionsDelete")
		.log("body to OlbSessionsCacheDelete  : ${body}")		
		.setHeader(EhcacheConstants.ACTION, constant(EhcacheConstants.ACTION_REMOVE))
        .setHeader(EhcacheConstants.KEY, header("uniqueId").convertTo(String.class))
        .to(OLBSESSIONS_CACHE_ENDPOINT);
		
		
		
		from("direct:getData").routeId("ehcache-example-get")
        .log("ID = ${header.id} getting")
        .setHeader(EhcacheConstants.ACTION, constant(EhcacheConstants.ACTION_GET))
        .setHeader(EhcacheConstants.KEY, header("id").convertTo(Long.class))
        .to(EHCACHE_ENDPOINT)
        .log("body from cache : ${body} and headers ${headers}");
		
		
		
		from("direct:puData").routeId("ehcache-example-put")
        .log("ID = ${header.id} putting ${body}")
        .setHeader(EhcacheConstants.ACTION, constant(EhcacheConstants.ACTION_PUT))
        .setHeader(EhcacheConstants.KEY, header("id").convertTo(Long.class))
        .to(EHCACHE_ENDPOINT)
        .log("body : ${body}");
		
	}

}
