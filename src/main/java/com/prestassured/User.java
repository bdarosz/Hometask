package com.prestassured;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    public String login;
    public int id;

    @JsonProperty("public_repos")
    public int publicRepos;//jackson accepts _ underscore if cammelcase is used it will bring an error, we can add JSON Property to use cammelcase and don't brake coding convetions

    public String getLogin () {return login;}
    public int getId(){return id;}
    public int getPublic_repos(){return publicRepos;}
}
