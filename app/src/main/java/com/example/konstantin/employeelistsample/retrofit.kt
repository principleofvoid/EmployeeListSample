package com.example.konstantin.employeelistsample

import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface EmployeeDataService {
    @GET("static/testTask.json")
    fun getEmployeeData(): Single<EmployeeData>
}

//HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/principleofvoid/EmployeeListSample/master/")
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

val employeeDataService: EmployeeDataService = retrofit.create(EmployeeDataService::class.java)