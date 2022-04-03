package com.prestassured.m8configuration;

import com.prestassured.User;
import groovy.util.logging.Log;
import groovy.util.logging.Slf4j;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import lombok.extern.apachecommons.CommonsLog;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.prestassured.ConfigFactory.getDefaultConfig;

@CommonsLog

public class _1ConfigDemo {
    public static final String BASE_URL = "https://api.github.com/users/rest-assured";

    @BeforeSuite
    void setup(){
        RestAssured.config = getDefaultConfig();
    }

    @Test
    public void cleanTestWithHiddenConfig() {
        User user = RestAssured.get(BASE_URL)
                .as(User.class);//chain as method meaning unmarshall JSON response as User class
        Assert.assertEquals(user.login,"rest-assured");
        Assert.assertEquals(user.id, 19369327L);
    }
}
