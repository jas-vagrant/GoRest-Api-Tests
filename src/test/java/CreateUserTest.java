
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static users.UsersClient.*;

public class CreateUserTest {

    @Test
    public void shouldCreateMaleUser(){

        //Arrange
        String body = "{\n" +
                "  \"name\": \"Jaspreet Singh\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"jas.jsingh@1346ce.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";

        //Act
        createUserResponse(body)
                .then()
                .log().body()

        //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("jas.jsingh@1346ce.com"))
                .body("data.name",Matchers.equalTo("Jaspreet Singh"));
    }

    @Test
    public void shouldCreateFemaleUser(){

        //Arrange
        String body = "{\n" +
                "  \"name\": \"Aditi Rao\",\n" +
                "  \"gender\": \"female\",\n" +
                "  \"email\": \"aditir.rao@143ce.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";

        //Act
        createUserResponse(body)
                .then()
                .log().body()

        //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("aditir.rao@143ce.com"))
                .body("data.name",Matchers.equalTo("Aditi Rao"));
    }

}
