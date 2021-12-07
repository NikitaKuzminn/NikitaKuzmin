package home.epam.hw9.service;

import static home.epam.hw9.util.Parameters.KEY;
import static home.epam.hw9.util.Parameters.TOKEN;
import static home.epam.hw9.util.Values.USER_KEY;
import static home.epam.hw9.util.Values.USER_TOKEN;
import static org.hamcrest.Matchers.lessThan;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpStatus;

public class CommonService {
    protected Method requestedMethod;
    protected Map<String, String> queryParameters;
    protected Map<String, String> pathParameters;

    public CommonService(Method requestedMethod, Map<String, String> queryParams,
                         Map<String, String> pathParams) {
        this.requestedMethod = requestedMethod;
        this.queryParameters = queryParams;
        this.pathParameters = pathParams;
    }

    public static ResponseSpecification okResponseSpec() {
        return new ResponseSpecBuilder()
            .expectStatusCode(HttpStatus.SC_OK)
            .expectContentType(ContentType.JSON)
            .expectResponseTime(lessThan(10000L))
            .build();
    }

    public static ResponseSpecification notFoundResponseSpec() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.TEXT)
            .expectStatusCode(HttpStatus.SC_NOT_FOUND)
            .build();
    }

    public String stringConverter() {
        StringBuilder builder = new StringBuilder();
        pathParameters.keySet().forEach(p -> builder.append("{").append(p).append("}").append("/"));
        return builder.toString();
    }

    public Response sendRequest(RequestSpecification request) {
        return RestAssured
            .given(request).log().body()
            .pathParams(pathParameters)
            .queryParams(queryParameters)
            .queryParam(KEY, USER_KEY)
            .queryParam(TOKEN, USER_TOKEN)
            .request(requestedMethod, stringConverter())
            .prettyPeek();
    }

    public RequestSpecification requestSpec(URI url) {
        return new RequestSpecBuilder()
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .setBaseUri(url)
            .build();
    }
}
