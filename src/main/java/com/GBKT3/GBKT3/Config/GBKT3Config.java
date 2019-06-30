package com.GBKT3.GBKT3.Config;

import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.apache.xalan.processor.TransformerFactoryImpl;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.GBKT3.GBKT3.util.UrlEncodeHelper;

@Configuration
public class GBKT3Config {

//	@Bean
//	ServletRegistrationBean servletRegistrationBean() {
//		ServletRegistrationBean servlet = new ServletRegistrationBean(new CamelHttpTransportServlet(), "/GBK/*");
//		servlet.setName("CamelServlet");
//		return servlet;
//	}
	
//	@Bean
//	ServletRegistrationBean servletRegistrationBean() {
//		ServletRegistrationBean servlet = new ServletRegistrationBean(new DefaultCame);
//		servlet.setName("CamelServlet");
//		return servlet;
//	}
	
	
	@Bean
	UrlEncodeHelper encodeHelper() {		
		return new UrlEncodeHelper();
		
		
	}
	
	@Bean 
	TransformerFactoryImpl transformerFactoryImpl() {
		return new TransformerFactoryImpl();
	}
	
	
	@Bean
	XmlJsonDataFormat xmlJsonDataFormat() {
		
		XmlJsonDataFormat xmlJsonDataFormat= new XmlJsonDataFormat();
		xmlJsonDataFormat.setEncoding("UTF-8");
		xmlJsonDataFormat.setForceTopLevelObject(true);
		xmlJsonDataFormat.setSkipWhitespace(true);
		xmlJsonDataFormat.setTrimSpaces(true);
		xmlJsonDataFormat.setSkipNamespaces(true);
		xmlJsonDataFormat.setRemoveNamespacePrefixes(true);
		
		
		return xmlJsonDataFormat;
		
	}

}
