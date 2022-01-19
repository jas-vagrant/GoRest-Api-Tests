
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

import java.util.UUID;

import static java.lang.String.format;

public class CreateUserNegativeTest {


    //Arrange
    private UsersClient usersClient;
    private CreateUserRequestBody createUserRequestBody;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){
        //Arrange
        String name = "Jaspreet Singh";
        String gender = "male";
        String status = "active";
        String email = "jas.jsingh134ce.com";
        createUserRequestBody = new CreateUserRequestBody(name, gender, email, status);

        //Act
        usersClient.createUserResponse(createUserRequestBody)
                .then()
                .log().body()

        //Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }

}
