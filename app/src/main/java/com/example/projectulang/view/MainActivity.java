package com.example.projectulang.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.projectulang.R;
import com.example.projectulang.adapter.Adapter;
import com.example.projectulang.model.AlquranResponse;
import com.example.projectulang.presenter.MainPresenter;
import com.example.projectulang.presenter.MainView;

import java.util.List;


public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView A;
    private Adapter adapter;
    private MainPresenter mainPresenter;
    //private String institusi = "http://dev.farizdotid.com/api/instansi/semuainstansi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        A = findViewById(R.id.recyclerview);
        mainPresenter = new MainPresenter(this, this);
        mainPresenter.loadInstitusi();
    }

    @Override
    public void onSucces(List<AlquranResponse> instansiItems) {
        adapter = new Adapter(getApplicationContext(), instansiItems);
        A.setLayoutManager(new LinearLayoutManager(this));
        A.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(this, failureMessage, Toast.LENGTH_SHORT).show();
    }

    }

