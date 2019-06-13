package com.example.android.slider.datalayer.apiservices



import com.example.android.slider.models.splash.SettingsModel
import com.example.android.slider.models.splash.SplashData
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import java.util.concurrent.TimeUnit

interface APIServices{
    @GET("Splashes/getallsplashes.json")
     fun getSplashData():Observable<SplashData>
    @GET("Types/getdata.json")
    fun getSttingData():Observable<SettingsModel>
companion object{

     fun create(): APIServices {

         val okHttpClient = OkHttpClient.Builder()
             .readTimeout(30, TimeUnit.SECONDS)
             .connectTimeout(30, TimeUnit.SECONDS)
             .addInterceptor( HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
             .addInterceptor { chain ->
                 val originalRequest = chain.request()
                 val builder = originalRequest.newBuilder()
                 builder.addHeader("Authorization",
                     "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjIwMywiZXhwIjoxNTYwNzYzMDc2fQ.eoyfr3igCyMJxKuQ6D73Rhc1u49MzbM9YDaOkfpq9Uo")
                 val newRequest = builder.build()
                  chain.proceed(newRequest)
             }
                 
             .build()
         val retrofit = Retrofit.Builder()
             .baseUrl("http://parashote.codesroots.com/api/")
             .addConverterFactory(GsonConverterFactory.create())
             .addCallAdapterFactory( RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
             .client(okHttpClient)
             .build()


         return retrofit.create(APIServices::class.java)
 }
}
}