package com.slowmotion.kamuuapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.slowmotion.kamuuapp.model.ResponseMain
import com.slowmotion.kamuuapp.repo.RepositoryMain

class ViewModelMain: ViewModel() {

    val repository = RepositoryMain()

    var responGetData = MutableLiveData<List<ResponseMain>>()
    var isError = MutableLiveData<Throwable>()
    val isLoading = MutableLiveData<Boolean>()

    fun getDataView(){
        isLoading.value = true

        repository.getData({
            isLoading.value = false
            responGetData.value = it
        },{
            isLoading.value = false
            isError.value = it
        })
    }
}