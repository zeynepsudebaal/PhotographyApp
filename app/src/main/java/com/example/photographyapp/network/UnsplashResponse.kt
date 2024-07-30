package com.example.photographyapp.network

import com.example.photographyapp.model.UnsplashPhoto

data class UnsplashResponse(
    val total: Int,
    val results: List<UnsplashPhoto>
)
