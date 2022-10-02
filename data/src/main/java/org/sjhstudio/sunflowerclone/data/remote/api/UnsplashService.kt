package org.sjhstudio.sunflowerclone.data.remote.api

import org.sjhstudio.sunflowerclone.data.BuildConfig
import org.sjhstudio.sunflowerclone.data.remote.model.UnsplashSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface UnsplashService {

    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("client_id") clientId: String = BuildConfig.UNSPLASH_API_KEY
    ): UnsplashSearchResponse
}