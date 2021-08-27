package com.example.calling.client

import android.util.Base64
import com.example.calling.interfaces.InterfaceApi
import com.example.calling.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val AUTH =
        "Basic" + Base64.encodeToString("moomen:9124279".toByteArray(), Base64.NO_WRAP)

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val origin = chain.request()
            val requestBuilder = origin.newBuilder()
                .addHeader("Authorizition", AUTH)
                .method(origin.method(), origin.body())
            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()

    val instant: InterfaceApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        retrofit.create(InterfaceApi::class.java)
    }
}