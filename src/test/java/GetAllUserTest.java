

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.getAll.GetAllUserResponse;

public class GetAllUserTest {

    //Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void shouldGetAllUsers(){

    //Act
    GetAllUserResponse getAllUserResponse = usersClient.getAllUsers();

    //Arrange
    Assert.assertEquals(getAllUserResponse.getStatusCode(), 200);
    Assert.assertEquals(getAllUserResponse.getData().size(),20);
    Assert.assertTrue(getAllUserResponse.hasMaleUser());
    }

}
