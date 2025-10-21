package com.app.functional;

import io.restassured.builder.RequestSpecBuilder;

public class TestBase {
	//for testing git
	public RequestSpecBuilder reqspecbiulder = new RequestSpecBuilder();

	public void handleproxy(){
	String proxyip="";
	String proxyport="";

	if (proxyip!=null && proxyport!=null){
	reqspecbiulder.setProxy(proxyip, Integer.valueOf("proxyport"));
	}
	}

}
