package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportNG;
import resources.base;

public class listeners extends base implements  ITestListener {

	ExtentReports extent=ExtentReportNG.getReportObj();
	ExtentTest test;
	ThreadLocal<ExtentTest> testThread=new ThreadLocal<ExtentTest>();

	public void onFinish(ITestContext context) {	
          extent.flush();
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	
	public void onTestFailure(ITestResult result) {
		
		testThread.get().fail(result.getThrowable());
		
		WebDriver driver=null;
		String testCaseMethod=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
		}
		
		try {
			
			testThread.get().addScreenCaptureFromPath(getScreenShotPath(testCaseMethod,driver),result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestStart(ITestResult result) {
     
		 test=extent.createTest(result.getMethod().getMethodName());
		 testThread.set(test);
	}

	public void onTestSuccess(ITestResult result) {
          testThread.get().log(Status.PASS, "Test is passed");
	}

}
