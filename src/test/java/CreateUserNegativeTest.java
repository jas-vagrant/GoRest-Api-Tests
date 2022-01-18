
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUserNegativeTest {


    //Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){
        //Arrange
        String body = "{\n" +
                "  \"name\": \"Jaspreet Singh\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"jas.jsingh134ce.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";

        //Act
        usersClient.createUserResponse(body)
                .then()
                .log().body()

                //Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));
    }

}
