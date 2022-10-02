package org.sjhstudio.sunflowerclone.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UnsplashUserDto(
    @Json(name = "name") val name: String,
    @Json(name = "username") val username: String
)