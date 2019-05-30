package com.example.xlian_1.present;

import com.example.xlian_1.Bean.SBean;
import com.example.xlian_1.Callback.listCallBack;
import com.example.xlian_1.model.ListModel;
import com.example.xlian_1.view.listMyview;

public class listImPresent implements listPresent, listCallBack {
    private ListModel listModel;
    private listMyview listMyview;

    public listImPresent(ListModel listModel, com.example.xlian_1.view.listMyview listMyview) {
        this.listModel = listModel;
        this.listMyview = listMyview;
    }

    @Override
    public void getlist() {
        if (listModel != null) {
            listModel.getlist(this);
        }
    }

    @Override
    public void onSucces(SBean listbean) {
        if (listMyview != null) {
            listMyview.onSucces(listbean);
        }
    }

    @Override
    public void onFail(String errer) {
        if (listMyview != null) {
            listMyview.onFail(errer);
        }
    }
}
