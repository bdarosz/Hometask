package com.prestassured.petStore;

import io.restassured.RestAssured;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

@Log
@Slf4j
@CommonsLog

public class Pet {
    public static final String BASE_URL = "https://petstore.swagger.io/v2";
    @Test
    public void findByStatus() {
        RestAssured.get(BASE_URL + "/pet/findByStatus?status=sold")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
    @Test
    public void validatePetByID(){
        RestAssured.get(BASE_URL+"/pet/1")
                .then()
                .body("message", Matchers.containsString("Pet not found"))
                .body("type", Matchers.containsString("error"));
    }
}
