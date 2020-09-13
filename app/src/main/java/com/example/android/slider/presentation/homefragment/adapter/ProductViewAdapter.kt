package com.example.android.slider.presentation.homefragment.adapter

import android.annotation.SuppressLint
import android.bluetooth.BluetoothClass
import android.content.Context
import android.graphics.Color
import android.graphics.Color.parseColor
import android.graphics.PorterDuff
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.databinding.DataBindingUtil
import com.example.android.slider.databinding.ProductviewBinding
import com.example.android.slider.datalayer.usecases.CategoryUseCase
import com.example.android.slider.datalayer.usecases.SettingsUseCase

import android.widget.LinearLayout
import com.example.android.slider.R
import com.example.android.slider.datalayer.usecases.CategoryDesignUseCase
import com.example.android.slider.datalayer.usecases.setBackground
import kotlinx.android.synthetic.main.productview.view.*


class ProductViewAdapter (var data:List<CategoryUseCase> , var settingsUseCase: CategoryDesignUseCase) : RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return  data.size
    }
    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        p0.bind(data.get(p1),settingsUseCase)

    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {


        val  binding: ProductviewBinding = DataBindingUtil.inflate (LayoutInflater.from(p0.context),
            com.example.android.slider.R.layout.productview,p0,false)

        when(settingsUseCase.category_template){
            "0" -> {
                binding.constraintLayoutTamplate1.visibility = View.GONE
                binding.constraintLayoutTamplate2.visibility = View.GONE
                binding.constraintLayoutTamplate.setBackgroundResource(R.drawable.round_border_product)


            }
            "1" -> {
                 binding.constraintLayoutTamplate1.visibility = View.GONE
                 binding.constraintLayoutTamplate2.visibility = View.GONE
                 binding.constraintLayoutTamplate.setBackgroundResource(R.drawable.border_product)

            }
            "2" -> {
                binding.constraintLayoutTamplate2.visibility = View.GONE
                binding.constraintLayoutTamplate.visibility = View.GONE
                binding.constraintLayoutTamplate1.setBackgroundResource(R.drawable.round_border_product)

            }
            "3" -> {
                binding.constraintLayoutTamplate.visibility = View.GONE
                binding.constraintLayoutTamplate1.visibility = View.GONE
                binding.constraintLayoutTamplate2.setBackgroundResource(R.drawable.border_product)
                val params = LinearLayout.LayoutParams(MATCH_PARENT,WRAP_CONTENT)
                params.width = MATCH_PARENT
                params.topMargin = 16
                params.rightMargin = 16
                binding.MainconstraintLayout.setLayoutParams(params);

            }else -> {}
        }
        return  CustomViewHolder(binding)
    }


}
class CustomViewHolder (
    private val binding:ProductviewBinding
) : RecyclerView.ViewHolder(binding.root){

    fun bind( data: CategoryUseCase,settingsUseCase:CategoryDesignUseCase) {
         binding.catusecase = data
         binding.categorysettingusecase = settingsUseCase
    }

}
