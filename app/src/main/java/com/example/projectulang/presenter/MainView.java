package com.example.projectulang.presenter;

import com.example.projectulang.model.AlquranResponse;

import java.util.List;

public interface MainView {

    void onSucces(List<AlquranResponse> instansiItems);

    void onError(String errorMessage);

    void onFailure(String failureMessage);
}
