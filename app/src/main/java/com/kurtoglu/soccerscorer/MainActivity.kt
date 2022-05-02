package com.kurtoglu.soccerscorer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appretrofit.viewmodel.SoccerViewModel
import com.kurtoglu.soccerscorer.databinding.ActivityMainBinding
import com.kurtoglu.soccerscorer.model.SoccerResponse
import kotlinx.android.synthetic.main.activity_main.*

private val SoccerAdapter = com.kurtoglu.soccerscorer.adapter.SoccerAdapter()
private var macList: ArrayList<SoccerResponse.SoccerResponseItem> = arrayListOf()
private lateinit var binding: ActivityMainBinding
private var SoccerAPIService = com.kurtoglu.soccerscorer.service.SoccerAPIService()
private lateinit var soccerViewModel: SoccerViewModel




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        soccerViewModel = ViewModelProvider(this).get(SoccerViewModel::class.java)

        soccerViewModel.soccerList()
        observableLiveData()

        rv_items.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rv_items.adapter = SoccerAdapter
    }

    private fun observableLiveData() {
        soccerViewModel.soccerListLiveData.observe(this) {
            it.forEach { res ->
                macList.add(res)
            }
            SoccerAdapter.setSoccerData(macList)


        }

    }
}
   /*

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
            */






