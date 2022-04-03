package com.prestassured.m8configuration;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class _0GlobalConstantsDemo {

    @BeforeSuite
    public void setup(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        RestAssured.basePath = "posts";
    }

    @Test
    public void testOneUsingGlobalConstants(){
        RestAssured.get()
                .then()
                .body("userId[0]",is(1));
    }

    @Test
    public void testTwoUsingGlobalConstants(){
        RestAssured.get()
                .then()
                .body("userId[1]",is(1));
    }
}
