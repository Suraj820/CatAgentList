package com.java.catagentlist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.java.catagentlist.model.CatBreed
import com.java.catagentlist.model.CatUiModel
import com.java.catagentlist.model.Gender


//
// Created by Suraj on 08/04/22.
private val FEMALE_SYMBOL by lazy {
    HtmlCompat.fromHtml("&#9793;", HtmlCompat.FROM_HTML_MODE_LEGACY)
}

private val MALE_SYMBOL by lazy {
    HtmlCompat.fromHtml("&#9794;", HtmlCompat.FROM_HTML_MODE_LEGACY)

}
private const val UNKNOWN_SYMBOL = "?"

class CatViewHolder(
    private val containerView: View,
   val imageLoader: ImageLoader,
    private val onClickListener: OnClickListener
) : RecyclerView.ViewHolder(containerView) {
    private val catBiographyView: TextView by lazy { containerView.findViewById(R.id.item_cat_biography) }
    private val catBreedView: TextView by lazy { containerView.findViewById(R.id.item_cat_breed) }
    private val catGenderView: TextView by lazy { containerView.findViewById(R.id.item_cat_gender) }
    private val catNameView: TextView by lazy { containerView.findViewById(R.id.item_cat_name) }
    private val catPhotoView: ImageView by lazy { containerView.findViewById(R.id.item_cat_photo) }


    fun bindData(catData : CatUiModel)  {
        containerView.setOnClickListener{onClickListener.onClick(catData)}
        imageLoader.loadImage(catData.imageUrl,catPhotoView )
        catNameView.text = catData.name
        catBreedView.text = when (catData.breed) {
            CatBreed.AmericanCurl -> "American Curl"
            CatBreed.BalineseJavanese -> "Balinese-Javanese"
            CatBreed.ExoticShorthair -> "Exotic Shorthair"
        }
        catBiographyView.text = catData.biography
        catGenderView.text = when (catData.gender) {
            Gender.Female -> FEMALE_SYMBOL
            Gender.Male -> MALE_SYMBOL
            else -> UNKNOWN_SYMBOL
        }
    }
    interface OnClickListener{
        fun onClick(catData: CatUiModel)
    }
}