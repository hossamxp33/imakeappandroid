package com.example.android.slider.presentation.homefragment.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.android.slider.R
import com.example.android.slider.databinding.FamousProductviewBinding

import com.example.android.slider.datalayer.usecases.FamousProductUseCase
import com.example.android.slider.datalayer.usecases.SettingsUseCase

class FamousProductAdapter(var data:List<FamousProductUseCase>, var settingsUseCase: SettingsUseCase) : RecyclerView.Adapter<FamousViewHolder>() {

    override fun getItemCount(): Int {
        return  data.size
    }
    override fun onBindViewHolder(p0: FamousViewHolder, p1: Int) {
        p0.bind(data.get(p1))

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): FamousViewHolder {


        val  binding: FamousProductviewBinding = DataBindingUtil.inflate (LayoutInflater.from(p0.context),
           R.layout.famous_productview,p0,false)
        when(settingsUseCase.product_template){
            "1" -> {


            }
            "2" -> {

            }
            "3" -> {

            }else -> {}
        }
        return  FamousViewHolder(binding)
    }


}
class FamousViewHolder (
    private val binding: FamousProductviewBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind( data: FamousProductUseCase) {
        binding.famoususecase = data

    }

}
