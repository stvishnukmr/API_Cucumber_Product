package com.app.functional;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import junit.framework.Assert;

import java.io.File;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;

import io.cucumber.datatable.DataTable;

public class Stepdefinition {

	@Given("set baseURL {string}")
	public void set_base_url(String baseURL) {
		RestAssured.baseURI = baseURL;
	}

	@Given("set basePath {string}")
	public void set_base_path(String basePath) {
		RestAssured.basePath = basePath;
	}

	@When("set headers")
	public void set_headers(DataTable dataTable) {
		Map<String, String> asMap = dataTable.asMap();
		asMap.forEach((key, value) -> GlobalProperties.addglobalheaders(key, value));
	}

	@When("click getsend")
	public void click_getsend() {
		new Implementation().gettest();
	}

	@When("set inputpayload {string}")
	public void set_inputpayload(String fileget) {
		File fileinput = new File(fileget);
		GlobalProperties.setInputpayload(fileinput);
	}

	@When("click postsend")
	public void click_postsend() {
		new Implementation().posttest();
	}

	@Then("validate the statuscode {int}")
	public void validate_the_statuscode(Integer int1) {
		GlobalProperties.getResponse().statusCode();

	}

	@Then("validate the response {string}")
	public void validate_the_response(String string) {
		String asString = GlobalProperties.getResponse().body().asString();
		asString.contains(string);
	}

	@Then("validate the ID {string} as {string}")
	public void validate_the_id_as(String value, String att) {
		String asString = GlobalProperties.getResponse().body().asString();
		String string = JsonPath.parse(asString).read(att).toString();
		Assert.assertEquals(string, value);
	}

	@Then("validate the Title {string} as {string}")
	public void validate_the_title_as(String value, String attr) {
		String asString = GlobalProperties.getResponse().body().asString();
		String string3 = JsonPath.parse(asString).read("$."+attr).toString();
		Assert.assertEquals(string3, value);
	}

	@Then("validate the Price {string} as {string}")
	public void validate_the_price_as(String value, String attr) {
		String asString = GlobalProperties.getResponse().body().asString();
		String string3 = JsonPath.parse(asString).read(attr).toString();
		Assert.assertEquals(string3, value);
	}

	@Then("and teardown")
	public void and_teardown() {
		GlobalProperties.reset();
	}

}
