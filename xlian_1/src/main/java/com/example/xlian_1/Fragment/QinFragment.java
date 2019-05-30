package com.example.xlian_1.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xlian_1.Adapter.HomeAdapter;
import com.example.xlian_1.Adapter.QInAdapter;
import com.example.xlian_1.Bean.SBean;
import com.example.xlian_1.R;
import com.example.xlian_1.model.ListImModel;
import com.example.xlian_1.present.listImPresent;
import com.example.xlian_1.view.listMyview;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class QinFragment extends Fragment implements listMyview {


    private RecyclerView rlv;
    private ArrayList<SBean.DataBean.DatasBean> list;
    private QInAdapter adapter;

    public QinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        listImPresent listImPresent = new listImPresent(new ListImModel(), this);
        listImPresent.getlist();
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        rlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        rlv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        list = new ArrayList<>();
        adapter = new QInAdapter(getContext(), list);
        rlv.setAdapter(adapter);
    }

    @Override
    public void onSucces(SBean listbean) {
        list.addAll(listbean.getData().getDatas());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String errer) {
        Log.i("123", "=====>" + errer);
    }
}
