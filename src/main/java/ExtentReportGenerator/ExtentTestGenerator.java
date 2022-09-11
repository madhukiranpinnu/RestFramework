package ExtentReportGenerator;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentTestGenerator {
    private ExtentTestGenerator(){

    }
    private static ThreadLocal<ExtentTest> extentTestThreadLocal=new ThreadLocal<>();

    public static void setExtentTest(ExtentTest test){
        extentTestThreadLocal.set(test);
    }

    public static ExtentTest getExtentTest(){
        return extentTestThreadLocal.get();
    }
}
