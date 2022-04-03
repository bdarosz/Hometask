package com.prestassured.m5body;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
@Log
@Slf4j
@CommonsLog
public class _4DefaultParserDemo {
    public static final String BASE_URL = "https://petstore.swagger.io/v2/swagger.json";

    @Test
    public void parserAndSyntacticSugar(){
        RestAssured.get(BASE_URL)
                .then()
                .using()
               // .defaultParser(Parser.XML) //expected XML on website and test fails
                .body("info.contact.email", equalTo("apiteam@swagger.io"));
        log.info("Test executed");
    }
}
