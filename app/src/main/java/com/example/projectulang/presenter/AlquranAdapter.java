package com.example.projectulang.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.projectulang.R;
import com.example.projectulang.model.AlquranResponse;

import java.util.List;


public class AlquranAdapter extends ArrayAdapter<AlquranResponse> {
    private List<AlquranResponse> alquranResponseList;
    private Context context;

    public AlquranAdapter(List<AlquranResponse> alquranResponseList, Context context) {
        super(context, 0, alquranResponseList);
        this.alquranResponseList = alquranResponseList;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View itemView = convertView;


        if(itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        }


        AlquranResponse one_repo = alquranResponseList.get(position);

        TextView name = itemView.findViewById(R.id.judul);
        TextView desc = itemView.findViewById(R.id.ar);

        name.setText(one_repo.getId());
        desc.setText(one_repo.getAr());


        return itemView;
    }

}