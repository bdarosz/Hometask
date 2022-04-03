package com.prestassured.m6objectmapping;

import com.prestassured.User;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ObjectMappingDemo {
    public static final String BASE_URL = "https://api.github.com/users/rest-assured";

    @Test
    public void objectMappingTestOne() {
        User user = RestAssured.get(BASE_URL)
                .as(User.class);//chain as method meaning unmarshall JSON response as User class

        Assert.assertEquals(user.getLogin(),"rest-assured");
        Assert.assertEquals(user.getId(), 19369327L);
        Assert.assertEquals(user.getPublic_repos(), 2);
    }

    @Test
    public  void objectMappingRelyingOnMapperType(){
        User user = RestAssured.get(BASE_URL)
                .as(User.class, ObjectMapperType.JACKSON_2);

        Assert.assertEquals(user.getLogin(),"rest-assured");
    }

}
