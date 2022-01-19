
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;

public class CreateUserNegativeTest {


    //Arrange
    private UsersClient usersClient;
    private CreateUserRequestBody createUserRequestBody;
    private CreateUserErrorResponse createUserErrorResponse;

    @BeforeClass
    public void beforeClass() {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail() {
        //Arrange
        createUserRequestBody = CreateUserRequestBody.builder().name("Jaspreet Singh").gender("male")
                .email("jas.jsingh134ce.com").status("active").build();

        //Act
        createUserErrorResponse = usersClient.createUserErrorResponse(createUserRequestBody);

        //Assert
        Assert.assertEquals(createUserErrorResponse.getStatusCode(), 422);
        createUserErrorResponse.assertHasError("email", "is invalid");

    }

    @Test
    public void shouldNotAllowToCreateUserWithBlankGenderAndStatus() {
        //Arrange
        createUserRequestBody = CreateUserRequestBody.builder().name("Jaspreet Singh").gender("")
                .email("jas.jsingh134ce.com").status("").build();

        //Act
        createUserErrorResponse = usersClient.createUserErrorResponse(createUserRequestBody);

        //Assert
        Assert.assertEquals(createUserErrorResponse.getStatusCode(), 422);
        createUserErrorResponse.assertHasError("gender", "can't be blank");
        createUserErrorResponse.assertHasError("status", "can't be blank");

    }

}
