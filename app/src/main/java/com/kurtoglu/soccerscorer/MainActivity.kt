package com.kurtoglu.soccerscorer

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.kurtoglu.soccerscorer.adapter.SoccerAdapter
import com.kurtoglu.soccerscorer.databinding.ActivityMainBinding
import com.kurtoglu.soccerscorer.model.SoccerResponse
import com.kurtoglu.soccerscorer.service.SoccerAPI
import com.kurtoglu.soccerscorer.service.SoccerAPIService
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

private val SoccerAdapter = com.kurtoglu.soccerscorer.adapter.SoccerAdapter()
private var macList: ArrayList<SoccerResponse.SoccerResponseItem> = arrayListOf()
private lateinit var binding: ActivityMainBinding
private var SoccerAPIService = com.kurtoglu.soccerscorer.service.SoccerAPIService()



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        SoccerAPIService.getMaclar()
            .subscribeOn(Schedulers.newThread())
            .subscribeWith(object : DisposableSingleObserver<SoccerResponse>() {
                @RequiresApi(Build.VERSION_CODES.O)
                override fun onSuccess(takimlar: SoccerResponse) {
                    runOnUiThread {
                        SoccerAdapter.setSoccerData(takimlar)
                        takimlar.forEach {

                            macList.add(it)

                        }
                    }/*


                        SoccerAdapter.setSoccerData(takimlar)
                        Log.i("response", takimlar.toString())
                        */


                }
                override fun onError(e: Throwable) {
                    e.printStackTrace()
                    Log.i("response", "hatalı")
                }
            })



        rv_items.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rv_items.adapter = SoccerAdapter
    }
}