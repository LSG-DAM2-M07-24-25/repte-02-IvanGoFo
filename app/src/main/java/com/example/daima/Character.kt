package com.example.daima

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Character(navController: NavController) {

    val characterImages = listOf(
        R.drawable.gomah,
        R.drawable.goku,
        R.drawable.vegeta,
        R.drawable.piccolo,
        R.drawable.supreme,
        R.drawable.masked_majin
    )

    var myCharacter by remember { mutableIntStateOf(1)};

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
                    .size(300.dp)
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
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxWidth(),
            ){

                items((0..5).toList()) { character ->
                    if (myCharacter == character){
                        Box(
                            modifier = Modifier
                                .clickable { myCharacter = character }
                                .background(Color.LightGray)
                        ){
                            Image(
                                contentScale = ContentScale.FillBounds,
                                painter = painterResource(
                                    id = characterImages[character]
                                ),
                                contentDescription = "Character icon",
                            )
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .clickable { myCharacter = character }
                        ){
                            Image(
                                contentScale = ContentScale.FillBounds,
                                painter = painterResource(
                                    id = characterImages[character]
                                ),
                                contentDescription = "Character icon",
                            )
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .clickable { navController.navigate(Routes.NameScreen.createRoute(myCharacter)) }
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.LightGray)
                    .padding(horizontal = 72.dp, vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Continuar",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Black,
                )
            }
        }
    }

}
