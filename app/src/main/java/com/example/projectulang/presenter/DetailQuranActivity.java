package com.example.projectulang.presenter;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectulang.R;
import com.squareup.picasso.Picasso;

public class DetailQuranActivity extends AppCompatActivity {
    TextView tvTitle, tvOverview;
    ImageView ivQuran;
    ActionBar toolbar;
    private static final String BASE_URL = "https://al-quran-8d642.firebaseio.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_quran);
        tvTitle = findViewById(R.id.judul);
        tvOverview = findViewById(R.id.tv_overview);
        ivQuran = findViewById(R.id.iv_movie);
        toolbar = getSupportActionBar();


        String title = getIntent().getStringExtra("title");
        String overview = getIntent().getStringExtra("overview");
        String gambar = getIntent().getStringExtra("gambar");
        toolbar.setTitle(title);

        tvTitle.setText(title);
        tvOverview.setText(overview);
        Picasso.get().load(BASE_URL + gambar).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(ivQuran);

    }
}
