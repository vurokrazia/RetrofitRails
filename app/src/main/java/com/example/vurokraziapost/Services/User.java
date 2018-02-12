package com.example.vurokraziapost.Services;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jmartinez on 11/02/18.
 */

public class User {

    @SerializedName("id")
    @Expose
    String id;

    @SerializedName("email")
    @Expose
    String email;

    @SerializedName("hobby")
    @Expose
    String hobby;

    @SerializedName("full_name")
    @Expose
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
