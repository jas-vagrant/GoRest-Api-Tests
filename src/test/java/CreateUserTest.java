
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

import java.util.UUID;

import static java.lang.String.format;

public class CreateUserTest {

    //Arrange
    private UsersClient userClient;

    @BeforeClass
    public void beforeClass(){
        userClient = new UsersClient();
    }

    @Test
    public void shouldCreateMaleUser(){

        //Arrange
        String email = format("%s@gmail.com", UUID.randomUUID());
        String body = format("{\n" +
                "  \"name\": \"Jaspreet Singh\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"%s\",\n" +
                "  \"status\": \"active\"\n" +
                "}",email);

        //Act
        userClient.createUserResponse(body)
                .then()
                .log().body()

        //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo(email))
                .body("data.name",Matchers.equalTo("Jaspreet Singh"));
    }

    @Test
    public void shouldCreateFemaleUser(){

        //Arrange
        String email = format("%s@gmail.com", UUID.randomUUID());
        String body = format("{\n" +
                "  \"name\": \"Aditi Rao\",\n" +
                "  \"gender\": \"female\",\n" +
                "  \"email\": \"%s\",\n" +
                "  \"status\": \"active\"\n" +
                "}",email);

        //Act
        userClient.createUserResponse(body)
                .then()
                .log().body()

        //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo(email))
                .body("data.name",Matchers.equalTo("Aditi Rao"));
    }

}
