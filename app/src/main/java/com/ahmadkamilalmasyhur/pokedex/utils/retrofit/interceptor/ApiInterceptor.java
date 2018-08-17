package com.ahmadkamilalmasyhur.pokedex.utils.retrofit.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ApiInterceptor implements Interceptor {

    public ApiInterceptor() {
    }

    /*
     * this method is used for intercept the request and the response
     * from the server, you can use {@link com.onmart.onmartdriver.constant.Constant#UNAUTHORIZED}
     * or others for the HttpCode there
     *
     * */

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .build();
        return chain.proceed(request);
    }
}
