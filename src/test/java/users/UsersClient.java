package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserResponse;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public CreateUserResponse createUserResponse(CreateUserRequestBody body) {

        Response response = createUser(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }

    public CreateUserErrorResponse createUserErrorResponse(CreateUserRequestBody body) {

        Response response = createUser(body);
        CreateUserErrorResponse createUserErrorResponse = response.as(CreateUserErrorResponse.class);
        createUserErrorResponse.setStatusCode(response.statusCode());
        return createUserErrorResponse;
    }


    public Response createUser(CreateUserRequestBody body) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 174e2d0a979662dd305a3d6aaee9dc8f16874404c4a120bd15ad22efa95eb0e6")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");

        response
                .then()
                .log().body();

        return response;
    }

    public Response getAllUsers() {
        return
                given()
                        .when()
                        .get("https://gorest.co.in/public/v1/users");
    }
}
