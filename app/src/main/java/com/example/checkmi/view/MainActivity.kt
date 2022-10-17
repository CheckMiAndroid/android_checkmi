package com.example.checkmi.view

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.checkmi.databinding.ActivityMainBinding
import com.example.checkmi.retrofit.MemberList
import com.example.checkmi.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //list로 각각의 member를 가져오기

        val list : Array<TextView> = arrayOf(binding.Seat0,binding.Seat1,binding.Seat2,binding.Seat3,binding.Seat4,binding.Seat5,binding.Seat6
            ,binding.Seat7,binding.Seat8,binding.Seat9,binding.Seat10,binding.Seat11,binding.Seat12,binding.Seat13,binding.Seat14,binding.Seat15
            ,binding.Seat16,binding.Seat17,binding.Seat18,binding.Seat19,binding.Seat20)
        // id 17이 없다

        val name_list : MutableList<String> = mutableListOf()


        //Retrofit 통신

        RetrofitBuilder.memberService.getAttendList().enqueue(object : Callback<MemberList> {
            override fun onResponse(call: Call<MemberList>, response: Response<MemberList>) {
                if (response.isSuccessful) {
                    Log.d("member", "onResponse: ${response.body()}")

                    var index : Int = 0

                    for (view : TextView in list ){

                        Log.d("damn", "")

                        if(response.body()!!.data[index].isAttend==1){

                            Log.d("jjoin", "${response.body()!!.data[index].id}")
                            Log.d("jjoin", "${response.body()!!.data[index].member.name}")

                            view.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#84DA8D"))
                        }
                        //name_list.add(response.body()!!.data[index].member.name)
                        //view.text="${response.body()!!.data[index].member.name}"
                        if (response.body()!!.data[index].member.github=="dummy"){
                            name_list.add("정보없음")
                        }
                        else {
                            name_list.add(response.body()!!.data[index].member.name)
                        }
                        index++
                    }
                }
            }

            override fun onFailure(call: Call<MemberList>, t: Throwable) {
                Log.d("shit", "No!: $t")
            }
        })

        //var text_count=0

        binding.Seat21.setOnClickListener{

            var name_index=0

            if (binding.Seat21.isChecked) {
                for (view : TextView in list){
                    view.text=name_list[name_index]
                    name_index++

                }
            }
            else{
                for (view : TextView in list){
                    view.text=""

                }
            }

        }
    }








}