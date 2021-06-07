package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import pojosNbodies.SuperClass;
import pojosNbodies.userPojos.UserList;

import static io.restassured.RestAssured.*;


public class userTests extends SuperClass {

    @Given("Creates List of Users")
    public void creates_list_of_users() {
        UserList user = new UserList(2, "johnsmith", "john", "smith", "johnsmith@domain.com", "johnsmith1123", "1545789524",2  );

        given()
                .spec(petStoreRequestSpec)
                .body(listOfUser())
                .contentType(ContentType.JSON).
        when()
                .post("/user/createWithList").
        then()
                .spec(petStoreResponseSpec)
        ;
    }

    @When("Create user")
    public void create_user() {
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"username\": \"string\",\n" +
                "  \"firstName\": \"string\",\n" +
                "  \"lastName\": \"string\",\n" +
                "  \"email\": \"string\",\n" +
                "  \"password\": \"string\",\n" +
                "  \"phone\": \"string\",\n" +
                "  \"userStatus\": 0\n" +
                "}";

        given()
                .spec(petStoreRequestSpec)
                .body(body)
                .contentType(ContentType.JSON).
        when()
                .post("/user/createWithList").
        then()
                .spec(petStoreResponseSpec)
        ;

    }
    @When("Updated user")
    public void updated_user() {
    }
    @When("Delete user")
    public void delete_user() {
    }
    @When("Logs user into the system")
    public void get_user_login_logs_user_into_the_system() {
    }
    @When("Logs out current")
    public void get_user_logout_logs_out_current() {
    }
    @When("Creates list of users")
    public void post_user_create_with_array_creates_list_of_users() {
    }
    @And("Get user by userName")
    public void get_user_get_user_by_user_name() {

    }

    @Then("Verify user deleted")
    public void verifyUserDeleted() {
    }
}
