package com.example.android.slider.presentation.homefragment.adapter

import android.bluetooth.BluetoothClass
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.ViewParent
import androidx.databinding.DataBindingUtil
import com.example.android.slider.databinding.ProductviewBinding
import com.example.android.slider.datalayer.usecases.CategoryUseCase
import com.example.android.slider.datalayer.usecases.SettingsUseCase

import android.widget.LinearLayout



class ProductViewAdapter (var data:List<CategoryUseCase> , var settingsUseCase: SettingsUseCase) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return  data.size
    }
    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        p0.bind(data.get(p1))

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {


        val  binding: ProductviewBinding = DataBindingUtil.inflate (LayoutInflater.from(p0.context),
            com.example.android.slider.R.layout.productview,p0,false)
        when(settingsUseCase.category_template){
            "1" -> {
                 binding.productImageTamplet2.visibility = View.GONE
                 binding.textViewTemplate2.visibility = View.GONE
                  binding.constraintLayoutTamplate.background = null
                 binding.textViewTemplate3.visibility = View.GONE
                // Set the width by params
                val params = LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
                params.width = WRAP_CONTENT
                binding.constraintLayoutTamplate.setLayoutParams(params);

            }
            "2" -> {
                binding.productImage.visibility = View.GONE
                binding.textView2.visibility = View.GONE
                binding.textViewTemplate3.visibility = View.GONE
                // Set the width by params
                val params = LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
                params.width = WRAP_CONTENT
                binding.constraintLayoutTamplate.setLayoutParams(params);
            }
            "3" -> {
                binding.productImage.visibility = View.GONE
                binding.textView2.visibility = View.GONE
                binding.textViewTemplate2.visibility = View.GONE

            }
        }
        return  CustomViewHolder(binding)
    }


}
class CustomViewHolder (
    private val binding:ProductviewBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind( data: CategoryUseCase) {
         binding.catusecase = data

    }

}
