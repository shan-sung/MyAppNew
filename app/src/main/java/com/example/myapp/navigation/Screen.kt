package com.example.myapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    data object Explore : Screen("explore", "Explore", Icons.Filled.Search)
    data object MyTrips : Screen("my_trips", "My Trips", Icons.AutoMirrored.Filled.List)
    data object Profile : Screen("profile", "Profile", Icons.Filled.Person)

    companion object {
        val allScreens = listOf(Explore, MyTrips, Profile)
    }
}