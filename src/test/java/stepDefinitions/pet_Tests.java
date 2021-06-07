package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojosNbodies.SuperClass;
import pojosNbodies.petPojos.Pets;

import static io.restassured.RestAssured.*;

public class pet_Tests extends SuperClass {

    public int petID;


    @Given("Add a new pet to the store")
    public void add_a_new_pet_to_the_store() {
        Response response =
                given()
                        .spec(petStoreRequestSpec)
                        .contentType(ContentType.JSON)
                        .body(petBody()).
                when()
                        .put("/pet").
                then()
                        .spec(petStoreResponseSpec)
                        .contentType(ContentType.JSON).
                extract()
                        .response()
                ;
        Pets pets = response.as(Pets.class);
        petID = pets.getId();
    }

    @When("Find pet by ID")
    public void find_pet_by_id() {

        given()
                .log().uri()
                .header("api_key", "special-key")
                .pathParam("petID",petID).
        when()
                .get("/pet/{petID}").
        then()
                .statusCode(200)
                .contentType(ContentType.JSON)
        ;
    }

    @When("Uploads an Image")
    public void uploads_an_image() {
    }
    @When("Update an existing pet")
    public void update_an_existing_pet() {
    }
    @When("Find pet by status")
    public void find_pet_by_status() {
    }
    @When("Updates a pet in the store with form data")
    public void updates_a_pet_in_the_store_with_form_data() {
    }
    @When("Delete a pet")
    public void delete_a_pet() {
    }
    @Then("Verify pet deleted")
    public void verify_pet_deleted() {
    }


}
