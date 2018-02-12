package com.example.vurokraziapost.Services;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jmartinez on 10/02/18.
 */

public class API {
    public static final String URL = "http://codigovurokrazia.com/";
    private static Retrofit retrofit = null;
    public static Retrofit getApi(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
    public static Retrofit getApis(){
        if(retrofit == null){
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(RailsResponse.class, new MyDeserializeer());
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }
        return retrofit;
    }
}
