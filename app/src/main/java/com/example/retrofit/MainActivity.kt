package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.RecyclerViewAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rf= Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build()

        var res:Api= rf.create(Api::class.java)

        var rs= res.getres()

        var recyclerView= this.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

//        var aa: Post=Post(1,"acs",11,"ad")
//        var x= mutableListOf<Post>(aa)

        rs.enqueue(object: Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {


                var x = response.body()

                var recyclerViewAdapter= x?.let { RecyclerViewAdapter(this@MainActivity, it) }
                recyclerView.adapter=recyclerViewAdapter


            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

        })

    }
}