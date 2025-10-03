package com.app.functional;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Implementation extends TestBase {

	public RequestSpecification setheaders() {

		RequestSpecification request = RestAssured.given(reqspecbiulder.build());

		List<Header> headerlist = new ArrayList<Header>();

		GlobalProperties.getGlobalheaders().forEach((key, value) -> headerlist.add(new Header(key, value)));

		Headers headers = new Headers(headerlist);

		return request.headers(headers);

	}

	public Response gettest() {

		RequestSpecification request = setheaders();
		request.log().all();
		Response response = null;
		response = request.get(RestAssured.baseURI + RestAssured.basePath);
		response.prettyPrint();
		GlobalProperties.setResponse(response);
		return response;

	}

	public Response posttest() {
		RequestSpecification request = setheaders();
		request.body(GlobalProperties.getInputpayload());
		request.log().all();
		Response response = null;
		response = request.post(RestAssured.baseURI + RestAssured.basePath);
		response.prettyPeek();
		GlobalProperties.setResponse(response);
		return response;

	}

	public Response puttest() {

		RequestSpecification request = setheaders();
		request.body(GlobalProperties.getInputpayload());
		request.log().all();
		Response response = null;
		response = request.put(RestAssured.baseURI + RestAssured.basePath);
		response.prettyPeek();
		GlobalProperties.setResponse(response);
		return response;

	}

}
