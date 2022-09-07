package com.slowmotion.kamuuapp.repo

import com.slowmotion.kamuuapp.model.ResponseMain
import com.slowmotion.kamuuapp.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class RepositoryMain {
    fun getData(responhandler: (List<ResponseMain>) -> Unit, errorhandler: (Throwable) -> Unit){
        ConfigNetwork.service().getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responhandler(it)
            }, {
                errorhandler(it)
            })
    }
}