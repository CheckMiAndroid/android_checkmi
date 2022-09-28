package com.example.checkmi.retrofit

import com.google.gson.annotations.SerializedName

data class MemberList(
    //SerializedName : 지정할 이름
    //val ___ : 표시할 이름
    @SerializedName("status")
    val status: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: List<Data>
)

data class Data(
    @SerializedName("id")
    val id: Int,
    @SerializedName("isAttend")
    val isAttend: Int,
//    @SerializedName("member")
//    val member: List<Member>

)

data class Member(
    val id: Int,
    val name: String,
    val grade: Int,
    val clazz: Int,
    val birthday: String,
    val email: String,
    val github: String,
    val phoneNumber: String,
)
