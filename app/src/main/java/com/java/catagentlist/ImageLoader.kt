package com.java.catagentlist

import android.widget.ImageView


//
// Created by Suraj on 08/04/22.
interface ImageLoader {
    fun loadImage(imageUrl: String, imageView: ImageView)
}