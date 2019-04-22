package com.example.projectulang.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.projectulang.R;

public class Detail_item extends AppCompatActivity {
    private TextView tv_ar, tv_idn, tv_nomor, tv_tr;
    private String a,b,c,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_quran);
        tv_ar = findViewById(R.id.ar);
        tv_idn = findViewById(R.id.idn);
        tv_nomor = findViewById(R.id.nomor);
        tv_tr = findViewById(R.id.tr);

        a = getIntent().getStringExtra("ar");
        b = getIntent().getStringExtra("id");
        c = getIntent().getStringExtra("nomor");
        d = getIntent().getStringExtra("tr");

        tv_ar.setText(a);
        tv_idn.setText(b);
        tv_nomor.setText(c);
        tv_tr.setText(d);
    }
}
