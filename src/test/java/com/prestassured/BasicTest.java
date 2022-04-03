package com.prestassured;

import io.restassured.RestAssured;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

@Log @Slf4j @CommonsLog
public class BasicTest {

    @Test
    public void someTest(){
        RestAssured.get("https://petstore.swagger.io/")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
