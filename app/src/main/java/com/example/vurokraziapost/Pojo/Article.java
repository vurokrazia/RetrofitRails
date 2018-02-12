package com.example.vurokraziapost.Pojo;

import android.text.Html;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmartinez on 11/02/18.
 */

public class Article {
    List<String> idlist;
    List<String> useridlist;
    List<String> titlelist;
    List<String> authorlist;
    List<String> hobbylist;
    List<String> bodylist;
    List<String> imagelist;
    List<String> email;

    public Article() {
        email = new ArrayList<>();
        titlelist = new ArrayList<>();
        bodylist = new ArrayList<>();
        imagelist = new ArrayList<>();
        idlist = new ArrayList<>();
        useridlist = new ArrayList<>();
        authorlist = new ArrayList<>();
        hobbylist = new ArrayList<>();
    }

    public List<String> getTitlelist() {
        return titlelist;
    }

    public void setTitlelist(String title) {
        this.titlelist.add(title);
    }

    public List<String> getBodylist() {
        return bodylist;
    }

    public void setBodylist(String body) {
        String b = Html.fromHtml(Html.fromHtml(body).toString()).toString();
        this.bodylist.add(b);
    }

    public List<String> getImagelist() {
        return imagelist;
    }

    public void setImagelist(String image) {
        this.imagelist.add(image);
    }

    public List<String> getIdlist() {
        return idlist;
    }

    public List<String> getUseridlist() {
        return useridlist;
    }

    public List<String> getAuthorlist() {
        return authorlist;
    }

    public List<String> getHobbylist() {
        return hobbylist;
    }

    public void setIdlist(String idlist) {
        this.idlist.add(idlist);
    }

    public void setUseridlist(String useridlist) {
        this.useridlist.add(useridlist);
    }

    public void setAuthorlist(String  authorlist) {
        this.authorlist.add(authorlist);
    }

    public void setHobbylist(String hobbylist) {
        this.hobbylist.add(hobbylist);
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email.add(email);
    }
}
