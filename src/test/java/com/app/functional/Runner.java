package com.app.functional;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Vishnu\\eclipse-workspace\\API_cucumber_product\\src\\test\\java\\com\\"
		+ "app\\functional\\product.feature"
		, glue = "com.app.functional"
		, dryRun = false
		, publish = true
		, monochrome = true
		, plugin = {
				"pretty"
				, "html:target/cucumber-reports.html"
				, "json:target/cucumber.json"
				, "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

})

public class Runner {

}
