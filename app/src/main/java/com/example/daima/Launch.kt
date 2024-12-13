package com.example.daima

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Launch(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(400.dp)
            ) {
                Image(
                    contentScale = ContentScale.FillBounds,
                    painter = painterResource(
                        id = R.drawable.dragonball_daima_logo
                    ),
                    contentDescription = "Game icon",
                    modifier = Modifier
                        .fillMaxSize()

                )
            }
            Box(
                modifier = Modifier
                    .clickable { navController.navigate(Routes.CharacterScreen) }
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.LightGray)
                    .padding(horizontal = 72.dp, vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Entrar",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Black,
                )
            }
        }
    }
}
