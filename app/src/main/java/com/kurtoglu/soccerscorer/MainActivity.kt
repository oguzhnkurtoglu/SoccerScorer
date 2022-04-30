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
private var eczaneNameList: ArrayList<String?> = arrayListOf()
private var eczaneList: ArrayList<SoccerResponse.SoccerResponseItem> = arrayListOf()
private lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





        rv_items.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rv_items.adapter = SoccerAdapter
    }
}