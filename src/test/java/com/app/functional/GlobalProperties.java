package com.app.functional;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class GlobalProperties {
	
	private static Map<String, String> globalheaders= new HashMap<String, String>();
	private static Response response=null;
	private static File inputpayload=null;

	public static Map<String, String> getGlobalheaders() {
		return globalheaders;
	}

	public static void setGlobalheaders(Map<String, String> globalheaders) {
		GlobalProperties.globalheaders = globalheaders;
	}

	public static Response getResponse() {
		return response;
	}

	public static void setResponse(Response response) {
		GlobalProperties.response = response;
	}

	public static File getInputpayload() {
		return inputpayload;
	}

	public static void setInputpayload(File inputpayload) {
		GlobalProperties.inputpayload = inputpayload;
	}

	public static void addglobalheaders(String key, String value){
	globalheaders.put(key, value);
	}

	public static void reset(){
	globalheaders= new HashMap<String, String>();
	response=null;
	inputpayload=null;
	}


}
