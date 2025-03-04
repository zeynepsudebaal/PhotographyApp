package com.example.photographyapp.network

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.time.temporal.TemporalQuery

interface UnsplashApi {
    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
        const val CLIENT_ID = "Cwvb2PoVnEWXvyOPnOuyNrmyiDbhG9k50GsNxVK-4ao"
    }

    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos")
    suspend fun searchPhotos(
      @Query("query") query: String,
      @Query("page") page: Int,
      @Query("per page") perPage: Int
    ): UnsplashResponse

    




}