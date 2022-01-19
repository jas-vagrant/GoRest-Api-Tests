
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
        createUserRequestBody = CreateUserRequestBody.builder().name("Jaspreet Singh").gender("male")
                .email("jas.jsingh134ce.com").status("active").build();

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
