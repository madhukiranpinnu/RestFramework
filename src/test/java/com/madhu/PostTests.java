package com.madhu;

import AnnotationsP.FrameworkAnnotations;
import ExtentReportGenerator.ExtentLogger;
import Pojo.Employee;
import RequestBuilder.RequestBuilder;
import Util.APIUtil;
import Util.RandomNumber;
import constants.FrameworkConstants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class PostTests {
    @FrameworkAnnotations(author = {"pinnu"},category = {"smoke","PostTests"})
    @Test
    public void Test1() {
        Employee employee = Employee.builder()
                .setId(RandomNumber.getId())
                .setFirst_name(RandomNumber.getFirstName())
                .setLast_name(RandomNumber.getLastName())
                .setEmail(RandomNumber.getEmil()).build();
        RequestSpecification requestSpecification= RequestBuilder.BuildRequestCalls().contentType(ContentType.JSON)
                .body(employee);
        Response response=requestSpecification.post("/employees");
        ExtentLogger.logRequest(requestSpecification);
        response.prettyPrint();
        ExtentLogger.PassWithJson(response.prettyPrint());

    }
    @FrameworkAnnotations(author = {"pinnu","sai"},category = {"regression","PostTests"})
    @Test
    public void Test2(){
           String object= APIUtil.
                   jsonConverToString(System.getProperty("user.dir")+"\\src\\test\\resources\\jsons\\Stusent.json")
                   .replace("roll_Number",String.valueOf(RandomNumber.getId()))
                   .replace("fname",RandomNumber.getFirstName())
                   .replace("lname",RandomNumber.getLastName())
                   .replace("email_Student",RandomNumber.getEmil());
        RequestSpecification requestSpecification = RequestBuilder.BuildRequestCalls().contentType(ContentType.JSON)
                .body(object);
              Response response=requestSpecification.post("/employees");
        ExtentLogger.logRequest(requestSpecification);
        response.prettyPrint();
    APIUtil.responseToFile(System.getProperty("user.dir")+"\\src\\test\\resources\\output\\output.json",response);
        ExtentLogger.PassWithJson(response.prettyPrint());

    }
    @FrameworkAnnotations(author = {"pinnu"},category = {"smoke","PostTests"})
    @Test
    public void Test3(Method method){
        String object= APIUtil.
                jsonConverToString(FrameworkConstants.getInstance().requestJsonPath+method.getName()+".json")
                .replace("roll_Number",String.valueOf(RandomNumber.getId()))
                .replace("fname",RandomNumber.getFirstName())
                .replace("lname",RandomNumber.getLastName())
                .replace("email_Student",RandomNumber.getEmil());
        RequestSpecification requestSpecification= RequestBuilder.BuildRequestCalls().contentType(ContentType.JSON)
                .body(object);
                Response response=requestSpecification.post("/employees");
        response.prettyPrint();
        ExtentLogger.logRequest(requestSpecification);
        APIUtil.responseToFile(FrameworkConstants.getInstance().responseJsonPath+method.getName()+".json",response);
        ExtentLogger.PassWithJson(response.prettyPrint());
    }
}
