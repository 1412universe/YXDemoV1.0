package com.example.brightinng.Tools.Http;


import org.json.JSONObject;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkhttpUtil {
    public static void okhttpManager(String url, JSONObject jasonObject, Callback callback){
        //okhttp的异步请求
        OkHttpClient okHttpClient  = new OkHttpClient();
        //参数1：请求参数 ，参数2：请求头和编码格式
        RequestBody requestBody = RequestBody.create(jasonObject.toString(), MediaType.get("application/json;charset = utf-8"));
        Request request = new Request.Builder().url(url).post(requestBody).build();
        //异步请求回调
        okHttpClient.newCall(request).enqueue(callback);

    }
}
