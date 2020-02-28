package com.learn.clientserver.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.learn.clientserver.data.EmpRetriever
import com.learn.clientserver.domain.EmpResult
import com.learn.clientserver.domain.Success
import com.learn.clientserver.presentation.Interactors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmpViewModel(application: Application) : AndroidViewModel(application),KoinComponent {

    val empLiveData : MutableLiveData<List<Success>> = MutableLiveData()
    val interactors : Interactors by inject()
    private val empRetriever = EmpRetriever()

    val callback = object : Callback<EmpResult> {
        override fun onFailure(call: Call<EmpResult>?, t: Throwable?) {
            Log.e("FetchDataFromServer", "Problem calling Employee API", t)
        }

        override fun onResponse(call: Call<EmpResult>?, response: Response<EmpResult>?) {
            response?.isSuccessful.let {
                val resultList = EmpResult(response?.body()?.success ?: emptyList())
                Log.e("FetchDataFromServer", "response body "+response.toString())
                Log.e("FetchDataFromServer", "response body items "+response?.body()?.success)
                GlobalScope.launch {
                    withContext(Dispatchers.IO) {
                        Log.e("FetchDataFromServer", "Server response "+response?.isSuccessful)
                        Log.e("FetchDataFromServer", "no of items "+resultList.success)
                        interactors.addAllEmp(resultList.success)
                    }
                    getAllEmp()
                }
            }
        }
    }

    fun update(empData: Success) {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                interactors.updateEmp(empData)
            }
            getAllEmp()
        }
    }

    fun fetchDataFromServer() {
        empRetriever.getEmployees(callback)
    }

    fun getAllEmp() {
        GlobalScope.launch {
            empLiveData.postValue(interactors.getEmpDetails())
        }
    }

}