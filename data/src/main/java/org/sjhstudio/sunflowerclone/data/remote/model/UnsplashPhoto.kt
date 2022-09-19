package org.sjhstudio.sunflowerclone.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UnsplashPhoto(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "urls") val urls: UnsplashPhotoUrls,
    @field:Json(name = "user") val user: UnsplashUser
)