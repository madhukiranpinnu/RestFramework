package ExtentReportGenerator;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.http.Header;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public final class ExtentLogger {
    private ExtentLogger(){

    }
    public static void Pass(String message){
        ExtentTestGenerator.getExtentTest().pass(message);
    }
    public static void Fail(String message){
        ExtentTestGenerator.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
    }
    public static void Info(String message){
        ExtentTestGenerator.getExtentTest().info(message);
    }
    public static void PassWithJson(String json){
        ExtentTestGenerator.getExtentTest().pass(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }
    public static void logRequest(RequestSpecification requestSpecification){
        QueryableRequestSpecification query= SpecificationQuerier.query(requestSpecification);
        ExtentTestGenerator.getExtentTest().info("Request Body");
        ExtentTestGenerator.getExtentTest().info(MarkupHelper.createCodeBlock(query.getBody(), CodeLanguage.JSON));
        ExtentTestGenerator.getExtentTest().info("Headers");
        for(Header header: query.getHeaders()){
            ExtentTestGenerator.getExtentTest().info(header.getName()+"--"+header.getValue());
        }
    }
}
