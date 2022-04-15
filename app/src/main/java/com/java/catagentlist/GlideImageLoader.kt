package com.java.catagentlist

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide


//
// Created by Suraj on 15/04/22.
class GlideImageLoader(private  val context: Context) : ImageLoader {
    override fun loadImage(imageUrl: String, imageView: ImageView) {
        Glide.with(context)
            .load(imageUrl)
            .centerCrop()
            .into(imageView)
    }
}