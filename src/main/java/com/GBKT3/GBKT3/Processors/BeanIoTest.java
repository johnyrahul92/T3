package com.GBKT3.GBKT3.Processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component("beanIoTest")
public class BeanIoTest  implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		//
		// StreamBuilder builder = new StreamBuilder("s1");
		// builder.format("fixedlength");
		// builder.addRecord(MyRecord.class);
		// StreamFactory factory = StreamFactory.newInstance();
		// factory.define(builder);
		// Unmarshaller unmarshaller = factory.createUnmarshaller("s1");
		// MyRecord record = (MyRecord) unmarshaller.unmarshal("123ASD4");
		// System.out.println(record.getNumber());
		// System.out.println(record.getText());
		//
		// System.out.println(unmarshaller.getRecordName());
		//
		
	}

}
