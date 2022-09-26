package org.sjhstudio.sunflowerclone.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UnsplashSearchResponse(
    @Json(name = "totalPages") val totalPages: Int,
    @Json(name = "results") val results: List<UnsplashPhoto>
)