package com.app.functional;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GenerateAuth extends TestBase{
	
	public String generateauthtoken(){
		String res=null;
		Response response =  RestAssured.given(reqspecbiulder.build())
		.baseUri("www.com")
		.formParam("client ID","ajhfajhf")
		.formParam("secreat","ajhfajhf")
		.formParam("grantaccess","ajhfajhf")
		.formParam("scope","ajhfajhf")
		.contentType(ContentType.URLENC)
		.accept(ContentType.JSON).post();

		return res= response.jsonPath().getString("access_toke");

		}

}
