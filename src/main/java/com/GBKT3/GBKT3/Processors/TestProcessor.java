package com.GBKT3.GBKT3.Processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.GBKT3.GBKT3.pojo.SampleRequest;

@Component("testProcessor")
public class TestProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		SampleRequest sampleRequest = new SampleRequest();
		
			exchange.getIn().setBody(sampleRequest);
		}

}
