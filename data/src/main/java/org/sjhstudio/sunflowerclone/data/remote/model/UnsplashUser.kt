package org.sjhstudio.sunflowerclone.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UnsplashUser(
    @Json(name = "name") val name: String,
    @Json(name = "username") val username: String
) {
    val attributeUrl: String
        get() {
            return "https://unsplash.com/$username?utm_source=sunflower&utm_medium=referral"
        }
}