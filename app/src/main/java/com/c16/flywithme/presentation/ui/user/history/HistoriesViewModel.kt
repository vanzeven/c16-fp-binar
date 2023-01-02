package com.c16.flywithme.presentation.ui.user.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.c16.flywithme.data.remote.ApiConfig
import com.c16.flywithme.data.request.HistoriesRequest
import com.c16.flywithme.data.response.HistoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoriesViewModel : ViewModel() {
    val listHistories: MutableLiveData<HistoryResponse?> = MutableLiveData()

    fun getHistoriesObserver(): MutableLiveData<HistoryResponse?> {
        return listHistories
    }

    fun getHistories() {
        val retro = ApiConfig.getApiService().histories(HistoriesRequest(id = 0))
        retro.enqueue(object : Callback<HistoryResponse> {
            override fun onResponse(
                call: Call<HistoryResponse>,
                response: Response<HistoryResponse>
            ) {
                if (response.isSuccessful) {
                    listHistories.postValue(response.body())
                } else {
                    listHistories.postValue(null)
                }
            }

            override fun onFailure(call: Call<HistoryResponse>, t: Throwable) {
                listHistories.postValue(null)
            }
        })
    }
}