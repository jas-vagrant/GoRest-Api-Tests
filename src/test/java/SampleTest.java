import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleTest {

    @Test
    public void shouldGetAllUsers(){

        given()
                .when()
                    .get("https://gorest.co.in/public/v1/users")
                .then()
                    .statusCode(200).log().body()
                    .body("data",Matchers.hasSize(20))
                    .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")));
    }

    @Test
    public void shouldCreateUser(){

        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 174e2d0a979662dd305a3d6aaee9dc8f16874404c4a120bd15ad22efa95eb0e6")
                .body("{\n" +
                        "  \"name\": \"Jaspreet Singh\",\n" +
                        "  \"gender\": \"male\",\n" +
                        "  \"email\": \"tenali.jsingh@13ce.com\",\n" +
                        "  \"status\": \"active\"\n" +
                        "}")
        .when()
                .post("https://gorest.co.in/public/v1/users")
        .then()
                .log().body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("tenali.jsingh@13ce.com"))
                .body("data.name",Matchers.equalTo("Jaspreet Singh"));
    }
}
