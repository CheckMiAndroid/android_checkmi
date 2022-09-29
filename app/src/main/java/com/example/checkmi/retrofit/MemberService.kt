package com.example.checkmi.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MemberService {
    @POST("member/add") // baseUrl + "user/유저아이디"
    fun postMemberAdd(): Call<Member> //Call안에 들어갈거?

    @GET("member/list")
    fun getMemberList(): Call<Member>

    @POST("attend/post") // baseUrl + "user/유저아이디"
    fun postAttendPost(): Call<Member> //Call안에 들어갈거?

    @GET("attend/id/{id}")
    fun getMember(@Path("id") id: Int): Call<Member>

    @GET("attend/list")
    fun getAttendList(): Call<MemberList>
}