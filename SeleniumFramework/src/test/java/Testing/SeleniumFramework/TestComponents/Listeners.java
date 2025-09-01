package Testing.SeleniumFramework.TestComponents;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReports;

public class Listeners implements ITestListener{
	ExtentTest test;
	//ExtentReports extent = ExtentReporterNG.getReportObject();
	//@override
	public void onTestStart(ITestResult result) {
		//test = extent.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Paased");
	}
	
	public void onTestFail(ITestResult result) {
		test.fail(result.getThrowable());
	}

}
