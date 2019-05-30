package com.example.xlian_1.model;

import com.example.xlian_1.Bean.SBean;
import com.example.xlian_1.Callback.listCallBack;
import com.example.xlian_1.api.Myservice;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListImModel implements ListModel {
    @Override
    public void getlist(final listCallBack listCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Myservice.List)
                .build();
        Myservice myservice = retrofit.create(Myservice.class);
        Observable<SBean> getlist = myservice.getlist();
        getlist.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SBean sBean) {
                        listCallBack.onSucces(sBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        listCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
