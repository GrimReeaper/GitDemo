package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReportObj()
	{
		
		String path=System.getProperty("user.dir")+"\\ExtentReports\\report.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Extent Report");
		reporter.config().setTheme(Theme.DARK);
		
        extent=new ExtentReports();	
        extent.attachReporter(reporter);
        extent.setSystemInfo("Shivam Nagpal", "Tester");
        return extent;
	}
	
	

}

