package com.example.photographyapp.model

import com.google.gson.annotations.SerializedName

data class UnsplashUser(
    val id: String,
    val username: String,
    val name: String,
    val links: UserLinks,
    @SerializedName("profile_image")
    val profileImage: UserProfileImage
)

data class UserProfileImage(
    val small: String,
    val medium: String,
    val large: String
)
data class UserLinks(
    val self: String,
    val html: String,
    val photos: String,
    val likes: String
)