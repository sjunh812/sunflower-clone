package org.sjhstudio.sunflowerclone.presentation.ui.detail.adapter

import android.annotation.SuppressLint
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT
import androidx.databinding.BindingAdapter

@SuppressLint("SetTextI18n")
@BindingAdapter("wateringText")
fun TextView.bindWateringText(wateringInterval: Int) {
    text = "${wateringInterval}일"
}

@BindingAdapter("renderHtml")
fun TextView.bindRenderHtml(description: String?) {
    if (description != null) {
        text = HtmlCompat.fromHtml(description, FROM_HTML_MODE_COMPACT)
        movementMethod = LinkMovementMethod.getInstance()
    } else {
        text = ""
    }
}