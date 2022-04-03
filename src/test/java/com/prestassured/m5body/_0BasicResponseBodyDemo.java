package com.prestassured.m5body;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

@Log
public class _0BasicResponseBodyDemo {
    public static final String BASE_URL = "https://petstore.swagger.io/v2/swagger.json";

    @Test
    public void jsonPathReturnsMap() {
        Response response = RestAssured.get(BASE_URL);

        ResponseBody<?> body = response.body();
        JsonPath jPath = body.jsonPath();

        JsonPath jPath2 = response.body().jsonPath();

        Map<String, String> fullJson = jPath2.get();
        Map<String, String> subMap = jPath2.get("info");
        Map<String, String> subMap2 = jPath2.get("info.contact");

        String description = jPath.get("info.description");
        String description2 = jPath.get("info.contact.email");

        // System.out.println(fullJson);
        log.info(fullJson.toString());
        System.out.println(subMap);
        System.out.println(subMap2);
        System.out.println(description);
        System.out.println(description2);

        Assert.assertEquals(description, "This is a sample server Petstore server.  You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, you can use the api key `special-key` to test the authorization filters.");
        Assert.assertEquals(description2, "apiteam@swagger.io");
    }

    @Test
    public void castingFailure() {
        JsonPath jsonPath = RestAssured.get(BASE_URL).body().jsonPath();//request and get jsonpath
        Map<String, String> isNull = jsonPath.get("bla.bla");//NullPointerExecption expected
        //String aMapdescription = jsonPath.get("info.contact");//returns a map of values not specfic value, ClassCastExecption expected
        // int description2 = jsonPath.get("info.contact.email");//ClassCastException expected
        Assert.assertNull(isNull);
    }
}
