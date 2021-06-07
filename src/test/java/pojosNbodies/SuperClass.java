package pojosNbodies;

import com.github.javafaker.Faker;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.*;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

public class SuperClass {

    private Faker faker = new Faker();
    private Random r = new Random();

    public static RequestSpecification petStoreRequestSpec;
    public static ResponseSpecification petStoreResponseSpec;

    static {
        petStoreRequestSpec =
                given()
                .log().uri()
                .header("api_key", "special-key")
        ;

        petStoreResponseSpec =
                expect().statusCode(200);
    }



    public Map<String, Object> petBody(){


        int randomNum = r.nextInt(9999);

        Map<String, Object> body = new LinkedHashMap<>();

        body.put("id", randomNum);

        Map<String, Object> categories = new LinkedHashMap<>();
        categories.put ( "id", randomNum );
        categories.put( "name", faker.dog().breed() );
        body.put( "category", categories );

        body.put( "name", faker.dog().name() );

        List<String> photoUrls = new ArrayList<>(Arrays.asList(faker.internet().url()));
        body.put("photoUrls", photoUrls);

        Map<String, Object> tagsMap = new LinkedHashMap<>();
        tagsMap.put("id", randomNum);
        tagsMap.put("name", faker.dog().gender());

        List<Map<String , Object>> tags = new LinkedList<>();
        tags.add(tagsMap);

        body.put("tags", tags);

        List<String> status = new ArrayList<>(Arrays.asList("available", "pending", "sold"));
        body.put("status", status.get(r.nextInt(3)));

        return body;
    }

    public List<Map<String, Object>> listOfUser(){

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("id",r.nextInt(9999));
        body.put("username", faker.name().username());
        body.put("firstName", faker.name().firstName());
        body.put("lastName", faker.name().lastName());
        body.put("email", faker.internet().emailAddress());
        body.put("password", faker.internet().password());
        body.put("phone", faker.phoneNumber().phoneNumber());
        body.put("userStatus", r.nextInt(10));

        List<Map<String, Object>> mapList = new ArrayList<>();
        mapList.add(body);
        return mapList;
    }

    public  Map<String, Object> userMap(){

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("id",r.nextInt(9999));
        body.put("username", faker.name().username());
        body.put("firstName", faker.name().firstName());
        body.put("lastName", faker.name().lastName());
        body.put("email", faker.internet().emailAddress());
        body.put("password", faker.internet().password());
        body.put("phone", faker.phoneNumber().phoneNumber());
        body.put("userStatus", r.nextInt(10));

        return body;
    }




}
