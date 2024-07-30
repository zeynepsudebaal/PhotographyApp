package com.example.photographyapp.model

data class UnsplashPhoto(
    val id: String,
    val width: Int,
    val height: Int,
    val description: String,
    val urls: UserPhotoUrls,
    val user: UnsplashUser
)

data class UserPhotoUrls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
)
