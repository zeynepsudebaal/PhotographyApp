package com.example.photographyapp.ui.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.photographyapp.R

@Composable
fun WelcomeScreen(onNavButtonClick: () -> Unit) {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Image(
            painter = painterResource(id = R.drawable.openning),
            contentDescription = "Camera Icon",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Experience Photography In a new Dimension",
            fontSize = 52.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            color = Color.White,
            textAlign = TextAlign.Left,
            lineHeight = 50.sp,
            modifier = Modifier
                .height(252.dp)
                .width(350.dp)
                .align(Alignment.Center)
        )
        Button(
            onClick = onNavButtonClick,
            shape = CircleShape,
            modifier = Modifier
                .padding(vertical = 54.dp, horizontal = 24.dp)
                .size(74.dp)
                .align(Alignment.BottomEnd)

        ) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Arrow Icon",
                modifier = Modifier.size(88.dp)
            )
        }
    }
}

/*@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier) {
    val list = listOf("Ciao","Ciao","Ciao","Ciao")
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(list){ item ->
            Text(text = item)
        }
    }
}*/

@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
    MaterialTheme {
        WelcomeScreen{}
    }
}