package com.GBKT3.GBKT3.util;

import java.net.URLEncoder;

public class UrlEncodeHelper {

    public String encodeUrl(String urlParamToEncode) throws Exception {
    	
    	System.out.println("calling encode helper  : " + urlParamToEncode);
		
        if (urlParamToEncode != null) {
            return URLEncoder.encode(urlParamToEncode, "UTF-8");
        } else {
            return urlParamToEncode;
        }
    }

}
