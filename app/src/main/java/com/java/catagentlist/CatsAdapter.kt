package com.java.catagentlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.java.catagentlist.model.CatUiModel


//
// Created by Suraj on 08/04/22.
class CatsAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<CatViewHolder>(){

    private val catsData = mutableListOf<CatUiModel>()


    fun setData(catsData: List<CatUiModel>) {
        this.catsData.clear()
        this.catsData.addAll(catsData)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_cat,
            parent, false)


        return CatViewHolder(view, imageLoader,object :
            CatViewHolder.OnClickListener {
            override fun onClick(catData: CatUiModel) = onClickListener.onItemClick(catData)
        })
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
       holder.bindData(catsData[position])
    }

    override fun getItemCount()  = catsData.size

    interface OnClickListener{
        fun onItemClick(catsData: CatUiModel)
    }

}