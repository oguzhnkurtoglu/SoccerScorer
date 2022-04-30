package com.kurtoglu.soccerscorer.service

import com.kurtoglu.soccerscorer.model.SoccerResponse
import io.reactivex.Single
import retrofit2.http.GET

interface SoccerAPI {


    companion object{
        const val MACLAR = "maclar"
    }

    @GET(MACLAR)
    fun getData() : Single<SoccerResponse>}