package com.example.projectulang.presenter;

import android.content.Context;

import com.example.projectulang.connection.BaseApp;
import com.example.projectulang.model.AlquranResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private Context context;
    private MainView mainView;
    //public static ApiService service;

    public MainPresenter(Context context, MainView mainView) {
        this.context = context;
        this.mainView = mainView;
    }
    public void loadInstitusi(){
        BaseApp.service.getAlquran().enqueue(new Callback<AlquranResponse>() {
            @Override
            public void onResponse(Call<AlquranResponse> call, Response<AlquranResponse> response) {
                if (response.isSuccessful()){
                    mainView.onSucces(response.body().getAr());

                } else {
                    mainView.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<AlquranResponse> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }
        });
    }
}
