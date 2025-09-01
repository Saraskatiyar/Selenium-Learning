package resources;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports {
	public static ExtentReports getReportObject() {
		String path = System.getProperty("")+"";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Sar");
		reporter.config().setDocumentTitle("Any");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
		
		
	}

	private void attachReporter(ExtentSparkReporter reporter) {
		// TODO Auto-generated method stub
		
	}

	
}
