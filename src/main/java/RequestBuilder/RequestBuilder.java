package RequestBuilder;
import Enums.ProprtyEnums;
import Util.PropertyUtils;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public final class RequestBuilder {// not to extend
    private RequestBuilder(){}// can't use Constructor
    public static RequestSpecification BuildRequestCalls(){
        return given()
                .baseUri(PropertyUtils.getValue(ProprtyEnums.BASEURL))
                .log()
                .all();
    }
}
