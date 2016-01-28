package com.example.pony.okhttpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建okHttp对象
        final OkHttpClient okHttpClient = new OkHttpClient();
        //创建请求对象
        final Request request = new Request.Builder().url("https://api.github.com/repos/square/okhttp/issues").header("User-Agent", "OkHttp Headers.java").addHeader("Accept", "application/json; q=0.5").addHeader("Accept", "application/vnd.github.v3+json").build();
        //得到响应对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                    response = okHttpClient.newCall(request).execute();
                    Log.e(TAG,"是否成功："+response.isSuccessful());
                    if(response.isSuccessful()){
//                        Toast.makeText(MainActivity.this,response.header("Server"),Toast.LENGTH_LONG).show();
//                        Toast.makeText(MainActivity.this,response.header("Date"),Toast.LENGTH_LONG).show();
//                        Toast.makeText(MainActivity.this,response.header("Vary"),Toast.LENGTH_LONG).show();
                        Log.e(TAG,"response.header(\"Server\")"+response.header("Server"));
                        Log.e(TAG,"response.header(\"Server\")"+response.header("Date"));
                        Log.e(TAG,"response.header(\"Server\")"+response.header("Vary"));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}







//private final OkHttpClient client = new OkHttpClient();
//    public void run() throws Exception {
//        Request request = new Request.Builder()
//                .url("https://api.github.com/repos/square/okhttp/issues")
//                .header("User-Agent", "OkHttp Headers.java")
//                .addHeader("Accept", "application/json; q=0.5")
//                .addHeader("Accept", "application/vnd.github.v3+json")
//                .build();
//        Response response = client.newCall(request).execute();
//        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//        System.out.println("Server: " + response.header("Server"));
//        System.out.println("Date: " + response.header("Date"));
//        System.out.println("Vary: " + response.headers("Vary"));
//    }




//Response response = client.newCall(request).execute();
//if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//        System.out.println("Server: " + response.header("Server"));
//        System.out.println("Date: " + response.header("Date"));
//        System.out.println("Vary: " + response.headers("Vary"));
//        }