package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public static Response createUserResponse(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 174e2d0a979662dd305a3d6aaee9dc8f16874404c4a120bd15ad22efa95eb0e6")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }
}
