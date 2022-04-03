package com.prestassured.m5body;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class _2ValidateNestedBodyDemo {
    public static final String BASE_URL = "https://petstore.swagger.io/v2";

    @Test
    public void nestedBodyValidation(){
        RestAssured.get(BASE_URL+"/swagger.json")
                .then()
                .rootPath("info")
                .body("version",Matchers.containsString("1.0.6"))
                .body("title",Matchers.containsString("Swagger Petstore"))
                .rootPath("info.license")
                .body("name", Matchers.containsString("Apache 2.0"))
                .body("url", Matchers.containsString("http://www.apache.org/licenses/LICENSE-2.0.html"))
                .noRootPath()
                .body("securityDefinitions.api_key.type", Matchers.containsString("apiKey"));
    }

}
