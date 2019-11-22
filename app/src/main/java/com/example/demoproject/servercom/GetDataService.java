package com.example.demoproject.servercom;

import com.example.demoproject.models.ConfigResponseObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("config")
    Call<ConfigResponseObject> getConfig();
}