package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber",glue="rahulshettyacademy.SeleniumFrameWorkDesign.Stepdesigns",monochrome=true,plugin={"html:target/cucumber.html"},tags="@E2Esubmission")
public class TestngTestrunner extends AbstractTestNGCucumberTests {
	
		
	}


