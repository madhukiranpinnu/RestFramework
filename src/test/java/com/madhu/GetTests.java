package com.madhu;

import AnnotationsP.FrameworkAnnotations;
import DataprovderPackage.DataProvider1;
import ExtentReportGenerator.ExtentLogger;
import RequestBuilder.RequestBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class GetTests {
    @FrameworkAnnotations(author = {"madhu","kiran"},category = {"regression","GetTests"})
    @Test
    public void Test1(){
       Response response= RequestBuilder.BuildRequestCalls()
               .get("/employees");
       response.prettyPrint();
       assertThat(response.getStatusCode()).isEven().isEqualTo(200);
       assertThat(response.jsonPath().getList("$")
               .size())
               .isPositive()
               .as("checking count")
               .isLessThan(89);
        ExtentLogger.PassWithJson(response.prettyPrint());
        JsonPath jsonPath=new JsonPath(response.asString());
        int s=jsonPath.getInt("data.size()");
        System.out.println(s);
    }
    @FrameworkAnnotations(author = {"madhu","pinnu"},category = {"smoke","GetTests"})
    @Test
    public void Test2(){
        Response response= RequestBuilder.BuildRequestCalls()
                .pathParam("id",400)
                .get("/employees/{id}");
        response.prettyPrint();
        assertThat(response.getStatusCode()).isEven().isEqualTo(200);
        assertThat(response.jsonPath().getString("first_name"))
                .isEqualTo("Percival");
        ExtentLogger.PassWithJson(response.prettyPrint());

    }
    @FrameworkAnnotations(author = {"pinnu"},category = {"smoke","GetTests"})
    @Test(dataProvider = "values",dataProviderClass = DataProvider1.class)
    public void Test3(Map<String,String> data){
        Response response= RequestBuilder.BuildRequestCalls()
                .pathParam("id",data.get("id"))
                .get("/employees/{id}");
        response.prettyPrint();
        assertThat(response.getStatusCode()).isEven().isEqualTo(200);
        assertThat(response.jsonPath().getString("first_name"))
                .isEqualTo(data.get("first_name"));
        assertThat(response.jsonPath().getString("last_name"))
                .isEqualTo(data.get("last_name"));
        assertThat(response.jsonPath().getString("email"))
                .isEqualTo(data.get("email"));
        ExtentLogger.PassWithJson(response.prettyPrint());
    }
}
