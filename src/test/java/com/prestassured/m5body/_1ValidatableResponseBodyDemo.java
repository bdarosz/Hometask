package com.prestassured.m5body;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class _1ValidatableResponseBodyDemo {
    public static final String BASE_URL = "https://petstore.swagger.io/v2";
    public static final String CASTED_URL = "http://swagger.io";

    @Test
    public void matcherExmaple(){
        RestAssured.get(BASE_URL)
                .then()
                .body("info.termsOfService",equalTo(CASTED_URL+"/terms/"));
    }
}
