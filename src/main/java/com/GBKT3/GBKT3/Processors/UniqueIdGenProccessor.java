package com.GBKT3.GBKT3.Processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component("uniqueIdGenProccessor")
public class UniqueIdGenProccessor implements Processor {


    private static String base = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabsdefghijklmnopqrstuvwxyz!@#$%^&&*()";
    private static Random random = new Random();

    private static final Logger LOGGER = LoggerFactory.getLogger(UniqueIdGenProccessor.class);

    public void process(Exchange exchange) throws Exception {
        //A convenient place to put a break point
        LOGGER.debug("----------------------------UniqueIdGenProccessor-------------------------------------");
        exchange.getIn().setHeader("uniqueId",randomString(16));
        LOGGER.debug("--------------------------- "+exchange.getIn().getHeader("uniqueId")+"--------------------------------------");


        LOGGER.debug("----------------------------UniqueIdGenProccessor-------------------------------------");
    }


    public static String randomString(int length){
        StringBuilder b = new StringBuilder();
        for(int i = 0; i < length; i++){
            b.append(base.charAt(random.nextInt(base.length())));
        }
        return b.toString();
    }
}
