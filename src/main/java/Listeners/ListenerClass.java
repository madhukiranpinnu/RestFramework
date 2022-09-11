package Listeners;

import AnnotationsP.FrameworkAnnotations;
import ExtentReportGenerator.ExtentLogger;
import ExtentReportGenerator.ExtentReportMethods;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener, ISuiteListener {
    public void onStart(ISuite suite) {
        ExtentReportMethods.Extentinit();
    }

    public void onFinish(ISuite suite) {
        ExtentReportMethods.ExtentTeardown();
    }
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportMethods.ExtentTestCreater(result.getName());
        ExtentLogger.Info(result.getName()+"Test Execution started");
        String[] authors=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author();
        ExtentReportMethods.addAuthor(authors);
        String[] categories=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category();
        ExtentReportMethods.addCategory(categories);
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.Pass(result.getName()+"test got passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
         ExtentLogger.Fail(result.getName()+"-->"+result.getThrowable());
    }
}
