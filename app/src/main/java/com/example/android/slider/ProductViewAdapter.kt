package com.example.android.slider

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ProductViewAdapter: RecyclerView.Adapter<ProductViewAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ProductViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val view=layoutInflater.inflate(R.layout.productview,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

    }


    class ProductViewHolder(val view: View):RecyclerView.ViewHolder(view){

    }
}