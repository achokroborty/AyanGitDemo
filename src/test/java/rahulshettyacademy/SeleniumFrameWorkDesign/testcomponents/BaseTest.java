package rahulshettyacademy.SeleniumFrameWorkDesign.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.SeleniumFrameWorkDesign.Pageobject.LandingPage;

public class BaseTest {
	
	WebDriver driver;
	public LandingPage lp;
	
	public WebDriver initialiseTest() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademy//SeleniumFrameWorkDesign//resources//GlobalData.properties");
		prop.load(fis);
		String browserName= System.getProperty("browser")!=null ?System.getProperty("browser"):prop.getProperty("browser");
		if(browserName.contains("chrome")) {
			//headless execution
		ChromeOptions options=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		if(browserName.contains("headless")) {
		options.addArguments("headless");
		}
		driver=new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1440,900));
		
		
		}
		

	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
}
	@BeforeMethod
	public LandingPage launchapplication() throws IOException {
		driver=initialiseTest();
		lp=new LandingPage(driver);
		lp.launchApplication();
		return lp;
	}
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	public List<HashMap<String,String>> getJsonDataToMap(String Filepath) throws IOException {
		
		String jsonContent = 	FileUtils.readFileToString(new File(Filepath), 
				StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>>data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
	});
		return data;
}
	public String getScreenshot(String testCaseName) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File desc=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, desc);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		
	}
	
	
}
