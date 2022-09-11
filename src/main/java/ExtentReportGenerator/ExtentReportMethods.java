package ExtentReportGenerator;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.lang.reflect.Method;

public final class ExtentReportMethods {
    private ExtentReportMethods(){

    }
    private static ExtentReports extentReports;
    private static ExtentTest test;

    public static void Extentinit(){
       extentReports=new ExtentReports();
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\src\\test\\resources\\reports\\index.html");
        extentReports.attachReporter(sparkReporter);
    }

    public static void ExtentTeardown(){
        extentReports.flush();
    }

    public static void ExtentTestCreater(String methodName){
       test=extentReports.createTest(methodName);
       ExtentTestGenerator.setExtentTest(test);
    }

    public static void addAuthor(String[] authors){
        for (String author:authors) {
            ExtentTestGenerator.getExtentTest().assignAuthor(author);
        }
    }
    public static void addCategory(String[] Categories){
        for (String category:Categories) {
            ExtentTestGenerator.getExtentTest().assignCategory(category);
        }
    }
}
