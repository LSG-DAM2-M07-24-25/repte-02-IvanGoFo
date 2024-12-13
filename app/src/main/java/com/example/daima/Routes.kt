package com.example.daima

open class Routes(val route: String) {
    object LaunchScreen : Routes("launchScreen")
    object CharacterScreen : Routes("caracterScreen")
    object NameScreen : Routes("nameScreen/{character}") {
        fun createRoute(character: Int) = "nameScreen/$character"
    }
    object ResultScreen : Routes("resultScreen/{character}/{name}") {
        fun createRoute(character: Int, name: String) = "nameScreen/$character/$name"
    }
}