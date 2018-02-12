package com.example.vurokraziapost.Services;

/**
 * Created by jmartinez on 10/02/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RailsResponse {

    @SerializedName("user")
    @Expose
    User user;
    @SerializedName("id")
    @Expose
    String id;

    @SerializedName("title")
    @Expose
    String title;

    @SerializedName("body")
    @Expose
    String body;

    @SerializedName("created_at")
    @Expose
    String created_at;

    @SerializedName("img_art")
    @Expose
    String resource;

    public RailsResponse() {
    }

    public RailsResponse(User user, String id, String title, String body, String created_at, String resource) {
        this.user = user;
        this.id = id;
        this.title = title;
        this.body = body;
        this.created_at = created_at;
        this.resource = resource;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
