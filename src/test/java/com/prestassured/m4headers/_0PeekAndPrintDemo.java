package com.prestassured.m4headers;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class _0PeekAndPrintDemo {

    public static final String BASE_URL = "https://petstore.swagger.io/";
//test the methods to view the content of the response
    @Test
    public void peek (){
        RestAssured.get(BASE_URL)
                .peek(); //print header and the body to the standard output
    }

    @Test
    public void prettyPeek (){
        RestAssured.get(BASE_URL)
                .prettyPeek();//formats the body to make it more readable
    }

    @Test
    public void print (){
        RestAssured.get(BASE_URL)
                .print();//prints only the body and returns as a string
    }
    @Test
    public void prettyPrint (){
        RestAssured.get(BASE_URL)
                .prettyPrint();//prints only the body and returns as a string
    }
}
