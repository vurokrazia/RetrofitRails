package com.example.vurokraziapost.Services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jmartinez on 10/02/18.
 */

public interface WebServices{

    @GET("/articles.json")
    Call<RailsResponse> all();

    @GET("/articles.json")
    Call<List<RailsResponse>> allparse();
}
