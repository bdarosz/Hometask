package com.prestassured.m7httpmethods;

import io.restassured.RestAssured;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;


@Log
@Slf4j
@CommonsLog
public class HeadAndOptionsDemo {
    public static final String BASE_URL = "https://petstore.swagger.io/";

    @Test
    public void headTest(){
        RestAssured.head(BASE_URL)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(emptyOrNullString());
    }

    @Test
    public void optionsTest(){
        RestAssured.options(BASE_URL)
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT)//no content
                .header("Access-Control-Allow-Methods",equalTo("GET, POST, OPTIONS"))
                .body(emptyOrNullString());
    }
}
