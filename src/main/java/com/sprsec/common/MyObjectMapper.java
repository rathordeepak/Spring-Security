package com.sprsec.common;

import java.util.Date;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;

public class MyObjectMapper extends ObjectMapper {
	public MyObjectMapper() {
		CustomSerializerFactory factory = new CustomSerializerFactory();
		factory.addSpecificMapping(Date.class, new CustomDateSerializer());
		this.setSerializerFactory(factory);
	}
}