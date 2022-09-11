package com.madhu;

import AnnotationsP.FrameworkAnnotations;
import ExtentReportGenerator.ExtentLogger;
import RequestBuilder.RequestBuilder;
import Util.APIUtil;
import Util.RandomNumber;
import constants.FrameworkConstants;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class Assignment_1{
    private int size=0;
    private int id=RandomNumber.getId();
    @FrameworkAnnotations(author = {"madhu"},category = {"smoke","Assignment_1"})
    @Test
    public void Test1(){
        Response response= RequestBuilder.BuildRequestCalls()
                .get("/employees");
        response.prettyPrint();
        assertThat(response.getStatusCode()).isEven().isEqualTo(200);
        ExtentLogger.PassWithJson(response.prettyPrint());
        JsonPath jsonPath=new JsonPath(response.asString());
        size=jsonPath.getInt("data.size()");
        System.out.println(size);
    }
    @FrameworkAnnotations(author = {"madhu","kiran"},category = {"regression","Assignment_1"})
    @Test
    public void Test2(Method method){
        String object= APIUtil.
                jsonConverToString(FrameworkConstants.getInstance().requestJsonPath+method.getName()+".json")
                .replace("roll_Number",String.valueOf(id))
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
        int responseCode=response.getStatusCode();
        Assert.assertEquals(responseCode,201);
        response.then()
                .body(JsonSchemaValidator
                        .matchesJsonSchema(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\jsons\\Schema.json")));
        int updatedsize=size++;
        System.out.println(size);

    }
    @FrameworkAnnotations(author = {"madhu"},category = {"smoke","Assignment_1"})
    @Test
    public void Test3(){
        Map<String,Object> map =new LinkedHashMap<>();
        map.put("first_name","madhuk");
        map.put("last_name","pinnukiran");
        map.put("email","madhuki@gmail.com");
        RequestSpecification requestSpecification = given()
                .pathParam("id",id)
                .header("Content-Type", "application/json")
                .body(map).log().all();

               Response response= requestSpecification.put(" http://localhost:3000/employees/{id}");
        response.prettyPrint();
        ExtentLogger.logRequest(requestSpecification);
        System.out.println(response.getStatusCode());
    }

    @FrameworkAnnotations(author = {"madhu","kiran"},category = {"regression","Assignment_1"})
    @Test
    public void Test5(){
        Response response = given()
                .pathParam("id",id)
                .delete(" http://localhost:3000/employees/{id}");
        System.out.println(response.getStatusCode());
        int updatedSize=size--;

    }
}
