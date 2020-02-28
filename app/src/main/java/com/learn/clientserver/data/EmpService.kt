package com.learn.clientserver.data

import com.learn.clientserver.domain.EmpResult
import retrofit2.Call
import retrofit2.http.GET

interface EmpService {

    @GET("viewreport.php")
    fun getEmpDetails() : Call<EmpResult>
}