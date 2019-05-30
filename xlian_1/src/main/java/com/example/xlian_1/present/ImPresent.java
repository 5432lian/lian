package com.example.xlian_1.present;

import com.example.xlian_1.Bean.Bann;
import com.example.xlian_1.Callback.CallBack;
import com.example.xlian_1.model.ImModel;
import com.example.xlian_1.view.Myview;

public class ImPresent implements Present, CallBack {
private ImModel imModel;
private Myview myview;

    public ImPresent(ImModel imModel, Myview myview) {
        this.imModel = imModel;
        this.myview = myview;
    }

    @Override
    public void getBann() {
        if (imModel!=null){
            imModel.getBann(this);
        }
    }

    @Override
    public void onSucces(Bann bann) {
        if (myview!=null){
            myview.onSucces(bann);
        }
    }

    @Override
    public void onFail(String errer) {
        if (myview!=null){
            myview.onFail(errer);
        }
    }
}
