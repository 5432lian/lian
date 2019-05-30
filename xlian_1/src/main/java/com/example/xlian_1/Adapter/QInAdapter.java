package com.example.xlian_1.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xlian_1.Bean.SBean;
import com.example.xlian_1.R;

import java.util.ArrayList;

public class QInAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<SBean.DataBean.DatasBean> list;

    public QInAdapter(Context mContext, ArrayList<SBean.DataBean.DatasBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.fragment_qin, null);
        ListItem listItem = new ListItem(inflate);
        return listItem;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListItem listItem = (ListItem) holder;
        listItem.home_te.setText(list.get(position).getTitle());
        Glide.with(mContext).load(list.get(position).getEnvelopePic()).into(listItem.home_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ListItem extends RecyclerView.ViewHolder {

        private ImageView home_img;
        private TextView home_te;

        public ListItem(View itemView) {
            super(itemView);
            home_img = itemView.findViewById(R.id.home_img);
            home_te = itemView.findViewById(R.id.home_te);
        }
    }
}
