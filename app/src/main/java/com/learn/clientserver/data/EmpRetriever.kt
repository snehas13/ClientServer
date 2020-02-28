package com.learn.clientserver.data

import com.learn.clientserver.domain.EmpResult
import com.learn.clientserver.presentation.Constants
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class EmpRetriever {

    private val service: EmpService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL) //1
            .addConverterFactory(GsonConverterFactory.create()) //3
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        service = retrofit.create(EmpService::class.java) //4
    }


    fun getEmployees(callback: Callback<EmpResult>) { //5
        val call = service.getEmpDetails()
        call.enqueue(callback)
    }

}