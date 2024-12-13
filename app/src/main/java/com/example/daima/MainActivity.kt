package com.example.daima

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.daima.ui.theme.DaimaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navigationController = rememberNavController()
            NavHost(
                navController = navigationController,
                startDestination = Routes.LaunchScreen
            ) {
                composable(Routes.LaunchScreen) { Launch(navigationController) }
                composable(Routes.CharacterScreen) { Character(navigationController) }
                composable(
                    route = Routes.NameScreen,
                    arguments = listOf(navArgument("character") { type = NavType.IntType })
                ) { backStackEntry ->
                    backStackEntry.arguments?.getInt("character")?.let {
                        Name(
                            navigationController,
                            it.or(1)
                        )
                    }
                }
                composable(
                    route = Routes.ResultScreen,
                    arguments = listOf(
                        navArgument("character") { type = NavType.IntType },
                        navArgument("name") { type = NavType.StringType }
                    )
                ) { backStackEntry ->
                    backStackEntry.arguments?.getInt("character")?.let {
                        Result(
                            navigationController,
                            it,
                            backStackEntry.arguments?.getString("name").orEmpty()
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaimaTheme {
        Greeting("Android")
    }
}