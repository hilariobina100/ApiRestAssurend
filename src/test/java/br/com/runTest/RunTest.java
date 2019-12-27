package br.com.runTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, snippets = SnippetType.CAMELCASE, plugin = { "pretty",
		"json:target/cucumber.json" }, features = {
				".//src//test//resources//" }, glue = { "steps", "configuration", "commons" },


		tags = { "@Teste01" })



public class RunTest{
	
	

}