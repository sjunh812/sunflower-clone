package org.sjhstudio.sunflowerclone.presentation.util

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("isGone")
fun View.bindIsGone(isGone: Boolean) {
    isVisible = !isGone
}

@BindingAdapter("imageFromUrl")
fun ImageView.bindImageFromUrl(imageUrl: String?) {
    if(!imageUrl.isNullOrEmpty()) {
        Glide.with(context)
            .load(imageUrl)
            .into(this)
    }
}