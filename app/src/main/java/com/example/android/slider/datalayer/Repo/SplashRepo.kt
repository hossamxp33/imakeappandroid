package com.example.android.slider.datalayer.Repo

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import com.example.android.slider.datalayer.apiservices.APIServices
import com.example.android.slider.datalayer.usecases.SplashUsecase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@SuppressLint("CheckResult")
class SplashRepo{
    fun getSplashData(livedata: MutableLiveData<List<SplashUsecase>>?){

        APIServices.create().getCompanyData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { data -> data.data?.map { photo -> SplashUsecase(photo) } }
            .subscribe(
                { books ->
                    livedata?.postValue(books)
                },
                { error ->

                }
            )

}

}