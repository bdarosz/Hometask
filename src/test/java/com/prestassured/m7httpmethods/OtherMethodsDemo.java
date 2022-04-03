package com.prestassured.m7httpmethods;

import io.restassured.RestAssured;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


@Log
@Slf4j
@CommonsLog
public class OtherMethodsDemo {
    public static final String BASE_URL = "https://api.github.com/user/repos";
    public static final String TOKEN = "";

    @Test(description = "create new repo")
    public void postTest(){
        RestAssured
                .given()
                    .header("Authorization","token "+TOKEN)
                    .body("{\"name\":\"deleteme\"}")
                .when()
                    .post(BASE_URL)
                .then()
                    .statusCode(HttpStatus.SC_CREATED);
    }
    @Test(description = "delete a  repo")
    public void deleteTest(){
        RestAssured
                .given()
                    .header("Authorization","token "+TOKEN)
                .when()
                    .delete("https://api.github.com/repos/bdarosz/deleteme")
                .then()
                    .statusCode(HttpStatus.SC_NO_CONTENT);
    }

}
