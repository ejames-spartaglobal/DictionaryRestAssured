package com.spartaglobal.dictionary_restassured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;


public class SingleEntryTest
{
    @BeforeClass
    public static void setup(){
        baseURI="https://od-api.oxforddictionaries.com:443/api/v2/";
        basePath="entries/en-gb/";
    }

    @Test
    public void entryGetRequestIsSuccessful()
    {
                given()
                .header("app_key", "e2e22af3f725aafe64eca3440d085036").and()
                .given()
                .header("app_id", "323147e8")
                .given()
                .contentType(ContentType.JSON)
                .get("example")
                .then()
                .statusCode(200)
                .body("results[0].lexicalEntries[0].entries[0].senses[0].thesaurusLinks[0].entry_id",equalTo("example"));

    }
}
