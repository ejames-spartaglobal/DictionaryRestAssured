package com.spartaglobal.dictionary_restassured;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class MultipleEntryTest {

    private static String entriesJSON = "{\"entries\":[\"house\"& \"home\"]}";
    private static JsonPath multipleEntriesResponse;

    @BeforeClass
    public static void setup(){
        baseURI="https://od-api.oxforddictionaries.com:443/api/v2/";
        basePath="entries/en-gb/";
        multipleEntriesResponse =
                given()
                        .header("app_key", "e2e22af3f725aafe64eca3440d085036").and()
                        .given()
                        .header("app_id", "323147e8")
                        .given()
                        .contentType(ContentType.JSON)
                        .body(entriesJSON)
                        .when()
                        .post()
                        .then()
                        .statusCode(200)
                        .extract()
                        .body()
                        .jsonPath();
    }

    @Test
    public void multipleEntriesTest(){
        System.out.println(multipleEntriesResponse.get("results").toString());
    }
}
