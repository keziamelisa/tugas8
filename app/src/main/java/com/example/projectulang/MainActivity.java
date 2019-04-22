package com.example.projectulang;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.projectulang.model.AlquranResponse;
import com.example.projectulang.presenter.AlquranAdapter;
import com.example.projectulang.presenter.DetailQuranActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView alquranList;
    static ArrayList<AlquranResponse> allAlquran = new ArrayList();
    AlquranAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alquranList = findViewById(R.id.recyclerview);

        getAllAlquran();


        alquranList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailQuranActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent);

            }
        });



    }
    void getAllAlquran(){


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();



        allAlquran.addAll(new Callback<List<AlquranResponse>>() {
            @Override
            public void onResponse(Call<List<AlquranResponse>> call, Response<List<AlquranResponse>> response) {
                if(response.isSuccessful()){

                    MainActivity.allAlquran = (ArrayList<AlquranResponse>) response.body();

                    System.out.println(MainActivity.allAlquran.get(0).getAr());

                    adapter = new AlquranAdapter(response.body(), getApplicationContext(context));
                    adapter.notifyDataSetChanged();
                    alquranList.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<List<AlquranResponse>> call, Throwable t) {

            }
        });




    }

}