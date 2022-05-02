package com.example.appretrofit.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kurtoglu.soccerscorer.model.SoccerResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class SoccerViewModel(application: Application) : BaseViewModel(application) {

    private val SoccerAPISer = com.kurtoglu.soccerscorer.service.SoccerAPIService()
    private val disposable = CompositeDisposable()

    private val soccerLiveData = MutableLiveData<SoccerResponse>()
    val soccerListLiveData : LiveData<SoccerResponse> = soccerLiveData

    fun soccerList(){
        disposable.add(
            SoccerAPISer.getMaclar()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<SoccerResponse>() {
                    override fun onSuccess(response: SoccerResponse) {
                        soccerLiveData.value = response
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }
}