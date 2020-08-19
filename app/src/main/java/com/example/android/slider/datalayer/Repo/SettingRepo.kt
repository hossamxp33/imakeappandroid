package com.example.android.slider.datalayer.Repo

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.android.slider.datalayer.apiservices.APIServices
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
@SuppressLint("CheckResult")
class SettingRepo {
fun getSettings(livedata: MutableLiveData<List<SettingsUseCase>>?, errormessage: MutableLiveData<String>?){
    APIServices.create().getSttingData()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map { data->data.data.map { data-> SettingsUseCase(data) }   }
        .subscribe(
            { data->
                livedata?.postValue(data)
            },
            { error ->postError(Throwable(),errormessage)


                }
        )
}
    fun postError(throwable: Throwable, errormessage: MutableLiveData<String>?) {
        errormessage?.postValue(throwable.toString())
    }
}