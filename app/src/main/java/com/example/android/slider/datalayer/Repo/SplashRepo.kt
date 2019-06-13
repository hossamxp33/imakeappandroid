package com.example.android.slider.datalayer.Repo

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import com.example.android.slider.datalayer.apiservices.APIServices
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import com.example.android.slider.datalayer.usecases.SplashUsecase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@SuppressLint("CheckResult")
class SplashRepo{
    fun getSplashData(
        livedata: MutableLiveData<List<SplashUsecase>>?,
        errormessage: MutableLiveData<String>?
    ){

        APIServices.create().getSplashData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { data -> data.data.map { photo -> SplashUsecase(photo) } }
            .subscribe(
                { books ->
                    livedata?.postValue(books)
                },
                { error ->postError(Throwable(), errormessage)

                }
            )

}

fun getSettings(livedata: MutableLiveData<SettingsUseCase>?,errormessage: MutableLiveData<String>?){
    APIServices.create().getSttingData()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map { data->  SettingsUseCase(data) }
        .subscribe(
            {
                    dataa->
                livedata?.postValue(dataa)
            },
            {
                error -> postError(Throwable(),errormessage)
            }
        )
}
     fun postError(throwable: Throwable, errormessage: MutableLiveData<String>?) {
         errormessage?.postValue(throwable.toString())
    }
}