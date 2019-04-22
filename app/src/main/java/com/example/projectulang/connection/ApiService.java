package com.example.projectulang.connection;

import com.example.projectulang.model.AlquranResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/surat/1.json")
    Call<AlquranResponse> getAlquran();
}
