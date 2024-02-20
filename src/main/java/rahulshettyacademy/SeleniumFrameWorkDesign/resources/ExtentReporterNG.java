package rahulshettyacademy.SeleniumFrameWorkDesign.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public  ExtentReports getReportobject() {
		
		String path=System.getProperty("user.dir")+"//reports/index.html";
		ExtentSparkReporter eps=new ExtentSparkReporter(path);

		eps.config().setReportName("Web Automation result");
		eps.config().setDocumentTitle("Test Results");

		ExtentReports extent=new ExtentReports();
		extent.attachReporter(eps);
		extent.setSystemInfo("Tester","Ayan");
        return extent;
		
	}
}
