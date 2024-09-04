package com.example.photographyapp.ui.screen.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.photographyapp.R
import com.example.photographyapp.model.UnsplashPhoto
import com.example.photographyapp.model.UnsplashUser
import com.example.photographyapp.model.UserLinks
import com.example.photographyapp.model.UserPhotoUrls
import com.example.photographyapp.model.UserProfileImage

@Composable
fun ExploreScreen(viewModel: ExploreViewModel, onNavButtonClick: () -> Unit) {
    val state by viewModel.uiState.collectAsState()

    when(state){
        is UiState.Loading -> {}
        is UiState.Error -> {}
        else -> {
            PhotoList( list = (state as UiState.Success).result){}
        }
    }
}

@Composable
fun PhotoList(list: List<UnsplashPhoto>, onNavButtonClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar()
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(list) { item ->
                ExploreItemCard(item = item)
            }
        }
    }
}

    @Composable
fun TopBar() {
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // ADD USER AND MENU ICON
            Icon(
                imageVector = Icons.Outlined.AccountCircle,
                contentDescription = "User Icon",
                modifier = Modifier
                    .size(40.dp)
            )
            Icon(
                imageVector = Icons.Outlined.Menu,
                contentDescription = "Menu Icon"
            )
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.padding(12.dp))
            Text(
                text = "Explore",
                fontSize = 24.sp,
                lineHeight = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.weight(1f)

            )
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                contentDescription = "Arrow Icon",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun ExploreItemCard(item: UnsplashPhoto) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box (modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2f)){
            Image(
                painter = rememberAsyncImagePainter("https://images.unsplash.com/photo-1423784346385-c1d4dac9893a?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=d60d527cb347746ab3abf5fccecf0271"),
                contentDescription = "image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth,

                )
        }
        //text
        Text(
            modifier = Modifier.padding(12.dp),
            text = item.description)

        //row
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(horizontal = 16.dp)

        ) {
            Image(
                painter = rememberAsyncImagePainter("https://images.unsplash.com/profile-1441298803695-accd94000cac?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=7cfe3b93750cb0c93e2f7caec08b5a41"),
                contentDescription = "profile image",
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = item.user.name)
            Spacer(modifier = Modifier.padding(horizontal = 90.dp))
            Icon(
                painter = painterResource(R.drawable.twotone_bookmark),
                contentDescription = "Bookmark Icon"

            )
        }
    }
}


/*@Preview(showBackground = true)
@Composable
fun ExploreItemPreview() {
    MaterialTheme {
        //WelcomeScreen{}
        ExploreItemCard(item = DataItem("Title", "Author", "https://images.unsplash.com/photo-1416339306562-f3d12fefd36f?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=263af33585f9d32af39d165b000845eb"))
    }
}*/

@Preview(showBackground = true)
@Composable
fun ExplorePreview() {
    MaterialTheme {
        val userPhotoUrl = UserPhotoUrls(
            "https://images.unsplash.com/photo-1416339306562-f3d12fefd36f",
            "https://hd.unsplash.com/photo-1416339306562-f3d12fefd36f",
            "https://images.unsplash.com/photo-1416339306562-f3d12fefd36f?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=92f3e02f63678acc8416d044e189f515",
            "https://images.unsplash.com/photo-1416339306562-f3d12fefd36f?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=263af33585f9d32af39d165b000845eb",
        )
        val links = UserLinks(
            "https://api.unsplash.com/users/gilleslambert",
            "http://unsplash.com/@gilleslambert",
            "https://api.unsplash.com/users/gilleslambert/photos",
            "https://api.unsplash.com/users/gilleslambert/likes"
        )
        val profileImage = UserProfileImage(
            "https://images.unsplash.com/placeholder-avatars/extra-large.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=0ad68f44c4725d5a3fda019bab9d3edc",
            "https://images.unsplash.com/placeholder-avatars/extra-large.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=356bd4b76a3d4eb97d63f45b818dd358",
            "https://images.unsplash.com/placeholder-avatars/extra-large.jpg?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=ee8bbf5fb8d6e43aaaa238feae2fe90d"
        )
        val dummyUser = UnsplashUser(
            id = "user123",
            username = "12sude",
            name = "Sude",
            links = links,
            profileImage = profileImage
        )
        val dummyPhoto = UnsplashPhoto(
            id = "photo123",
            width = 1920,
            height = 1080,
            description = "something",
            urls = userPhotoUrl,
            user = dummyUser
        )
        val userPhotoUrl2 = UserPhotoUrls(
            "https://images.unsplash.com/face-springmorning.jpg",
            "https://images.unsplash.com/face-springmorning.jpg?q=75&fm=jpg",
            "https://images.unsplash.com/face-springmorning.jpg?q=75&fm=jpg&w=1080&fit=max",
            "https://images.unsplash.com/face-springmorning.jpg?q=75&fm=jpg&w=400&fit=max",
        )
        val links2 = UserLinks(
            "https://api.unsplash.com/users/lionsdenpro",
            "https://unsplash.com/lionsdenpro",
            "https://api.unsplash.com/users/lionsdenpro/photos",
            "https://api.unsplash.com/users/lionsdenpro/likes",
        )
        val profileImage2 = UserProfileImage(
            "https://images.unsplash.com/face-springmorning.jpg?q=80&fm=jpg&crop=faces&fit=crop&h=32&w=32",
            "https://images.unsplash.com/face-springmorning.jpg?q=80&fm=jpg&crop=faces&fit=crop&h=64&w=64",
            "https://images.unsplash.com/face-springmorning.jpg?q=80&fm=jpg&crop=faces&fit=crop&h=128&w=128"
        )
        val dummyUser2 = UnsplashUser(
            id = "user1234",
            username = "12bal",
            name = "Bal",
            links = links2,
            profileImage = profileImage2
        )

        val dummyPhoto2 = UnsplashPhoto(
            id = "photo1234",
            width = 1920,
            height = 1080,
            description = "something2",
            urls = userPhotoUrl2,
            user = dummyUser2
        )
        PhotoList(list = listOf(dummyPhoto, dummyPhoto2)) {}
    }
}