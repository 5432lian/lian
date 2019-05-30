package com.example.xlian_1.api;

import com.example.xlian_1.Bean.Bann;
import com.example.xlian_1.Bean.SBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Myservice {
    String URl="https://www.wanandroid.com/";
     @GET("banner/json")
    Observable<Bann> getBann();
     String List="https://www.wanandroid.com/";
     @GET("project/list/1/json?cid=294")
    Observable<SBean>getlist();
}
