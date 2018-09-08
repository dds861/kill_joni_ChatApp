package com.chatserver.dd.chat.Server.Model;


import com.chatserver.dd.chat.Contract.APIService;
import com.chatserver.dd.chat.Server.View.UsersServer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ModelServer implements IModelServer {
    ;

    @Override
    public void getArrayList(final OnFinishedListener onFinishedListener) {


        try {
            String url = "http://killjoniast.myarena.ru/android/";

            Retrofit retrofit = null;

            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }


            APIService service = retrofit.create(APIService.class);
            Call<List<UsersServer>> call = service.getServerWords();

            call.enqueue(new Callback<List<UsersServer>>() {
                @Override
                public void onResponse(Call<List<UsersServer>> call, Response<List<UsersServer>> response) {

                    onFinishedListener.onFinished(response.body());

                }

                @Override
                public void onFailure(Call<List<UsersServer>> call, Throwable t) {

                }
            });
        } catch (Exception e) {

        }


    }


}
