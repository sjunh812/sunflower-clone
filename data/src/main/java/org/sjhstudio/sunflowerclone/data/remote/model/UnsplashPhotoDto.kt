package org.sjhstudio.sunflowerclone.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UnsplashPhotoDto(
    @Json(name = "id") val id: String,
    @Json(name = "urls") val urls: UnsplashPhotoUrlsDto,
    @Json(name = "user") val user: UnsplashUserDto
)