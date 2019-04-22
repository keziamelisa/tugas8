package com.example.projectulang.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectulang.R;
import com.example.projectulang.model.AlquranResponse;
import com.example.projectulang.view.Detail_item;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    private List<AlquranResponse> alquranResponses;
    private Context context;

    public Adapter( Context context, List<AlquranResponse> instansiItems) {
        this.alquranResponses = instansiItems;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.Holder holder, final int i) {
        holder.bind(i);
    }

    @Override
    public int getItemCount() {
        return alquranResponses.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private LinearLayout l_detail;
        private ImageView iv_cover;
        private TextView tv_ar, tv_idn, tv_nomor, tv_tr;
        public Holder(@NonNull View itemView) {
            super(itemView);
            tv_ar = itemView.findViewById(R.id.ar);
            tv_idn = itemView.findViewById(R.id.idn);
            tv_nomor = itemView.findViewById(R.id.nomor);
            tv_tr = itemView.findViewById(R.id.tr);
            iv_cover = itemView.findViewById(R.id.cover);
            l_detail = itemView.findViewById(R.id.detail);

        }

        public void bind(final int i) {
            tv_ar.setText(alquranResponses.get(i).getAr());
            tv_idn.setText(alquranResponses.get(i).getId());
            tv_nomor.setText(alquranResponses.get(i).getNomor());
            tv_tr.setText(alquranResponses.get(i).getTr());

            l_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent x = new Intent(context, Detail_item.class);
                    x.putExtra("ar", alquranResponses.get(i).getAr());
                    x.putExtra("idn", alquranResponses.get(i).getId());
                    x.putExtra("nomor", alquranResponses.get(i).getNomor());
                    x.putExtra("tr", alquranResponses.get(i).getTr());

                    x.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(x);
                    Toast.makeText(context, alquranResponses.get(i).getAr(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}