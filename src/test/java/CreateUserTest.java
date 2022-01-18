import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTest {

    @Test
    public void shouldCreateMaleUser(){

        //Arrange
        String body = "{\n" +
                "  \"name\": \"Jaspreet Singh\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"jas.jsingh@134ce.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";

        //Act
        createUserResponse(body)
                .then()
                .log().body()

        //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("jas.jsingh@134ce.com"))
                .body("data.name",Matchers.equalTo("Jaspreet Singh"));
    }

    @Test
    public void shouldCreateFemaleUser(){

        //Arrange
        String body = "{\n" +
                "  \"name\": \"Aditi Rao\",\n" +
                "  \"gender\": \"female\",\n" +
                "  \"email\": \"aditir.rao@13ce.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";

        //Act
        createUserResponse(body)
                .then()
                .log().body()

        //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("aditir.rao@13ce.com"))
                .body("data.name",Matchers.equalTo("Aditi Rao"));
    }

    private Response createUserResponse(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 174e2d0a979662dd305a3d6aaee9dc8f16874404c4a120bd15ad22efa95eb0e6")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }

}
