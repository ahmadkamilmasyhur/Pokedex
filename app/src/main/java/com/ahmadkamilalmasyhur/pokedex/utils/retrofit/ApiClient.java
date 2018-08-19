package com.ahmadkamilalmasyhur.pokedex.utils.retrofit;

import com.ahmadkamilalmasyhur.pokedex.utils.Constant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (null == retrofit) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .build();
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.POKEDEX_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();
        }
        return retrofit;
    }
}
