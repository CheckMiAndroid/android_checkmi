package com.example.checkmi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.inflate
import com.example.checkmi.databinding.ActivityMainBinding
import com.example.checkmi.retrofit.MemberList
import com.example.checkmi.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //list로 각각의 member를 가져오기
        val list : List<View> = listOf()

//        list[0].setOnClickListener()

        //Retrofit 통신
        val call = RetrofitBuilder.githubService.getAttendList()

        call.enqueue(object : Callback<MemberList> {
            override fun onResponse(call: Call<MemberList>, response: Response<MemberList>) {
                if (response.isSuccessful) {
                    Log.d("member", "onResponse: ${response.body()}")

                    var index : Int = 0

                    for (i : View in list ){


                        if(response.body()!!.data[index].isAttend==1){



                        }

                        index++

                    }

                }
            }

            override fun onFailure(call: Call<MemberList>, t: Throwable) {
                Log.d("shit", "No!: $t")
            }

        })
    }
}