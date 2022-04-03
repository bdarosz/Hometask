package com.prestassured.m5body;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class _3ValidatableResponseRepeatedItems {
    public static final String BASE_URL = "https://petstore.swagger.io/v2/swagger.json";

    @Test
    public void repatingItems(){
        RestAssured.get(BASE_URL)
                .then()
                .body("tags.name[0]", Matchers.containsString("pet"))
                .body("tags.description[0]",equalTo("Everything about your Pets"))
              //  .body("tags.name",containsInAnyOrder("pet","store"));//wants to find all elements
                .body("tags.name",hasItems("pet","store"))
                .body("tags.name",hasItem("pet"));

    }
}
