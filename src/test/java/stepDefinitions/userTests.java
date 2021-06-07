package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojosNbodies.SuperClass;
import pojosNbodies.userPojos.UserPojo;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class userTests extends SuperClass {

    String username;
    String password;
    Map<String, Object> previousMap;

    @Given("Creates List of Users")
    public void creates_list_of_users() {
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
//        UserList user = new UserList(50, "blabla", "blabla", "lastname", "email", "password", "phone", 5);
        Response response =
            given()
                    .spec(petStoreRequestSpec)
                    .body(userMap())
                    .contentType(ContentType.JSON).
            when()
                    .post("/user").
            then()
                    .spec(petStoreResponseSpec).
            extract()
                    .response()
            ;

        previousMap = response.jsonPath().getMap("");

        username = userMap().get("username").toString();
        password = userMap().get("password").toString();
    }
    @When("Updated user")
    public void updated_user() {
        given()
                .spec(petStoreRequestSpec)
                .pathParam("username", username)
                .body(previousMap).
        when()
                .put("/user/{username}").
        then()
                .spec(petStoreResponseSpec)
                .body("username", is(username))
        ;
    }

    @When("Logs user into the system")
    public void get_user_login_logs_user_into_the_system() {

        given()
                .spec(petStoreRequestSpec)
                .queryParam("username", username)
                .queryParam("password", password).
        when()
                .put("/user/login").
        then()
                .spec(petStoreResponseSpec)
        ;

    }
    @When("Logs out current")
    public void get_user_logout_logs_out_current() {
        get("/user/logout").
        then()
                .spec(petStoreResponseSpec)
                .body("message", is("ok"))
        ;
    }
    @When("Creates list of users")
    public void post_user_create_with_array_creates_list_of_users() {
        given()
                .spec(petStoreRequestSpec)
                .body(listOfUser())
                .contentType(ContentType.JSON).
        when()
                .post("/user/createWithArray").
        then()
                .spec(petStoreResponseSpec)
        ;
    }
    @And("Get user by userName")
    public void get_user_get_user_by_user_name() {
        given()
                .pathParam("username", username)
                .spec(petStoreRequestSpec).
        when()
                .get("/user/{username}").
        then()
                .spec(petStoreResponseSpec)
        ;
    }
    @When("Delete user")
    public void delete_user() {
        given()
                .pathParam("username", username)
                .spec(petStoreRequestSpec).
        when()
                .delete("/user/{username}").
        then()
                .spec(petStoreResponseSpec)
        ;
    }

    @Then("Verify user deleted")
    public void verifyUserDeleted() {
        given()
                .pathParam("username", username)
                .spec(petStoreRequestSpec).
        when()
                .get("/user/{username}").
        then()
                .statusCode(is(404))
        ;
    }
}
