package com.example.photographyapp.repository

import com.example.photographyapp.network.UnsplashApi
import com.example.photographyapp.network.UnsplashResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UnsplashRepository @Inject constructor(private val unsplashApi: UnsplashApi){

    suspend fun searchImage(query: String): Flow<UnsplashResponse> = flow{
       emit(unsplashApi.searchPhotos(query, 1, 10))
    }

}