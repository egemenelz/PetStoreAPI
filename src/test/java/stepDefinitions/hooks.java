package stepDefinitions;

import io.cucumber.java.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;



public class hooks {



    @Before
    public void setup(){
        baseURI = "https://petstore.swagger.io";
        basePath = "/v2";


    }

    @After
    public void close(){
        reset();
    }

}
