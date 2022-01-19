
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

import java.util.UUID;

import static java.lang.String.format;

public class CreateUserTest {

    //Arrange
    private UsersClient userClient;
    private CreateUserRequestBody createUserRequestBody;
    private CreateUserResponse createUserResponse;

    @BeforeClass
    public void beforeClass() {
        userClient = new UsersClient();
    }

    @Test
    public void shouldCreateMaleUser() {

        //Arrange
        createUserRequestBody = CreateUserRequestBody.builder().name("Jaspreet Singh").gender("male")
                .email(format("%s@gmail.com", UUID.randomUUID())).status("active").build();

        //Act
        createUserResponse = userClient.createUserResponse(createUserRequestBody);

        //Assert
        createUserResponse.assertUser(createUserRequestBody);

    }

    @Test
    public void shouldCreateFemaleUser() {

        //Arrange
        createUserRequestBody = CreateUserRequestBody.builder().name("Aditi Rao").gender("female")
                .email(format("%s@gmail.com", UUID.randomUUID())).status("active").build();

        //Act
        createUserResponse = userClient.createUserResponse(createUserRequestBody);

        //Assert
        createUserResponse.assertUser(createUserRequestBody);

    }

}
