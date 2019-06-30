package com.GBKT3.GBKT3.beanio;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record(minOccurs = 1, maxOccurs = 1)
public class MyRecord {

	
	@Field(at = 0, length = 3, minOccurs = 1)
    private String number;

    @Field(at = 3, length = 3, minOccurs = 1)   
    private String text;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
    
    
}
