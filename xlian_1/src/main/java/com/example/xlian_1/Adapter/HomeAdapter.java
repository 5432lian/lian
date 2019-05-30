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
import com.example.xlian_1.Bean.Bann;
import com.example.xlian_1.Bean.SBean;
import com.example.xlian_1.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<Bann.DataBean> beanList;
    private ArrayList<SBean.DataBean.DatasBean> list;
    private int newposition;

    public HomeAdapter(Context mContext, ArrayList<Bann.DataBean> beanList, ArrayList<SBean.DataBean.DatasBean> list) {
        this.mContext = mContext;
        this.beanList = beanList;
        this.list = list;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_bann, null);
            BannItem bannItem = new BannItem(inflate);
            return bannItem;
        } else {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.fragment_qin, null);
            ListItem listItem = new ListItem(inflate);
            return listItem;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {
            BannItem bannItem = (BannItem) holder;
            bannItem.bann.setImages(beanList).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Bann.DataBean bean = (Bann.DataBean) path;
                    Glide.with(mContext).load(bean.getImagePath()).into(imageView);
                }
            }).start();
        } else {
            if (beanList.size() > 0) {
                newposition = position - 1;
            }
            ListItem listItem = (ListItem) holder;
            listItem.home_te.setText(list.get(newposition).getTitle());
            Glide.with(mContext).load(list.get(newposition).getEnvelopePic()).into(listItem.home_img);
        }
    }

    @Override
    public int getItemCount() {
        if (beanList.size() > 0) {
            return list.size() + 1;
        } else {
            return list.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    class BannItem extends RecyclerView.ViewHolder {

        private Banner bann;

        public BannItem(View itemView) {
            super(itemView);
            bann = itemView.findViewById(R.id.bann);
        }
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
