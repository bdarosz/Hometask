package com.prestassured.m4headers;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class _1BasicResponseDemo {
    public static final String BASE_URL = "https://petstore.swagger.io/";

    @Test
    public void convenienceMethods(){
       Response response =  RestAssured.get(BASE_URL);
       assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
       assertEquals(response.getContentType(),"text/html");
    }

    @Test
    public void genericHeader(){
        Response response =  RestAssured.get(BASE_URL);
        assertEquals(response.getHeader("server"),"nginx");

    }

    @Test
    public void getHeaders(){
        Response response =  RestAssured.get(BASE_URL);
        Headers headers = response.getHeaders();
        String val = headers.getValue("header1"); //get a value for a particular header
        int size = headers.size();//get a number of all headers
       // List<Header> list = headers.asList(); //convert to traditional java list
        boolean isPresent = headers.hasHeaderWithName("header2");//check if there is a specific header
        assertFalse(isPresent);
    }

    @Test
    public void timeExample(){
        Response response =  RestAssured.get(BASE_URL);
        response.getTime();
        System.out.println(response.time());// tells measured response time in milliseconds
        System.out.println(response.getTimeIn(TimeUnit.MINUTES));
    }
}
