
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

import java.util.UUID;

import static java.lang.String.format;

public class CreateUserTest {

    //Arrange
    private UsersClient userClient;
    private CreateUserRequestBody createUserRequestBody;

    @BeforeClass
    public void beforeClass(){
        userClient = new UsersClient();
    }

    @Test
    public void shouldCreateMaleUser(){

        //Arrange
        String name = "Jaspreet Singh";
        String gender = "male";
        String status = "active";
        String email = format("%s@gmail.com", UUID.randomUUID());
        createUserRequestBody = new CreateUserRequestBody(name, gender, email, status);


        //Act
        userClient.createUserResponse(createUserRequestBody)
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
        String name = "Aditi Rao";
        String gender = "female";
        String status = "active";
        String email = format("%s@gmail.com", UUID.randomUUID());
        createUserRequestBody = new CreateUserRequestBody(name, gender, email, status);

        //Act
        userClient.createUserResponse(createUserRequestBody)
                .then()
                .log().body()

        //Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo(email))
                .body("data.name",Matchers.equalTo("Aditi Rao"));
    }

}
