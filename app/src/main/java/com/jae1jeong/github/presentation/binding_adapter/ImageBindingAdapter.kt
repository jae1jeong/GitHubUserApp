package com.jae1jeong.github.presentation.binding_adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

object ImageBindingAdapter {


    @JvmStatic
    @BindingAdapter("android:imageUrl")
    fun setImageView(imageView: ImageView,url:String?){
        url?.let {
            Glide.with(imageView.context)
                .load(it)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(imageView)
        }
    }
}