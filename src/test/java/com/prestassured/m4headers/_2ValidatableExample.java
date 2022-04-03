package com.prestassured.m4headers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.hamcrest.number.OrderingComparison;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class _2ValidatableExample {
    public static final String BASE_URL = "https://petstore.swagger.io/";

    @Test
    public void basicValidatableExample(){
        RestAssured.get(BASE_URL)
                .then()
                .assertThat()
                    .statusCode(HttpStatus.SC_OK)
                .and()
                    .contentType(ContentType.HTML);
    }

    @Test
    public void simpleHamcrestMatchers(){
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(200)
                .statusCode(Matchers.lessThan(300))
                .header("cache-control",Matchers.containsStringIgnoringCase("max-age=86400"))
                .time(Matchers.lessThan(2L), TimeUnit.SECONDS)
                .header("etag",Matchers.not(Matchers.emptyString()));
    }

    @Test
    public void complexHamcrestMatchers(){
        RestAssured.get(BASE_URL)
                .then()
                .header("date", date-> LocalDate.parse(date, DateTimeFormatter.RFC_1123_DATE_TIME),
                        OrderingComparison.comparesEqualTo(LocalDate.now())); //take the String from header "date", parse it and use formatter and compare it to today's date
    }

}
