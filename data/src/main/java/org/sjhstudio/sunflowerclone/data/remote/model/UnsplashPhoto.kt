package org.sjhstudio.sunflowerclone.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UnsplashPhoto(
    @Json(name = "id") val id: String,
    @Json(name = "urls") val urls: UnsplashPhotoUrls,
    @Json(name = "user") val user: UnsplashUser
)