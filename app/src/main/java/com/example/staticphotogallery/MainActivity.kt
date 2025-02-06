package com.example.staticphotogallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.staticphotogallery.ui.theme.StaticPhotoGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StaticPhotoGalleryTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    PhotoGallery(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PhotoItem(
    imageResId: Int,
    caption: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = caption,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = caption,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun PhotoGallery(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            PhotoItem(imageResId = R.drawable.image1, caption = "Photo 1")
            Spacer(modifier = Modifier.width(16.dp))
            PhotoItem(imageResId = R.drawable.image2, caption = "Photo 2")
            Spacer(modifier = Modifier.width(16.dp))
            PhotoItem(imageResId = R.drawable.image3, caption = "Photo 3")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            PhotoItem(imageResId = R.drawable.image4, caption = "Photo 4")
            Spacer(modifier = Modifier.width(16.dp))
            PhotoItem(imageResId = R.drawable.image5, caption = "Photo 5")
            Spacer(modifier = Modifier.width(16.dp))
            PhotoItem(imageResId = R.drawable.image6, caption = "Photo 6")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhotoGalleryPreview() {
    StaticPhotoGalleryTheme {
        PhotoGallery()
    }
}
