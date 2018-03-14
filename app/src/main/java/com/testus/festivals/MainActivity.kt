package com.testus.festivals

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutManager = LinearLayoutManager(this)
        my_recycler_view.layoutManager=layoutManager
        Thread(Runnable {
            val client = OkHttpClient()
            val request = Request.Builder()
                    .url("http://androidfest.ucoz.net/data/festivals.txt")
                    .build()
            val response = client.newCall(request).execute()
            val responseText = response.body()!!.string()

            var festival = Gson().fromJson(responseText, FestivalInfo.List::class.java)
            runOnUiThread {
                val adapter = ListAdapter(this, festival)
                my_recycler_view.adapter=adapter
            }
            android.util.Log.d("Fest", festival.joinToString { it.name })
        }).start()


    }
}
