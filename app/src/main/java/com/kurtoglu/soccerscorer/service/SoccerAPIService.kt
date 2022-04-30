package com.kurtoglu.soccerscorer.service

import com.kurtoglu.soccerscorer.model.SoccerResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class SoccerAPIService {

    private val BASE_URL = "https://oyunpuanla.com/futbolSkor/public/index.php/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(SoccerAPI::class.java)

    fun getMaclar(): Single<SoccerResponse> {
        return api.getData()
    }

}
