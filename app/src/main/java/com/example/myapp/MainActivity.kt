package com.example.myapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.myapp.ui.explore.ExploreScreen
import com.example.myapp.ui.myTrips.MyTripsScreen
import com.example.myapp.ui.profile.ProfileScreen
import com.example.myapp.ui.theme.MyAppTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.launch
import com.example.myapp.data.network.RetrofitClient
import com.example.myapp.navigation.BottomBar
import com.example.myapp.navigation.Screen
import com.example.myapp.ui.TopBar
import com.example.myapp.ui.explore.CityScreen
import com.example.myapp.ui.explore.TmpTripDetailsScreen
import com.example.myapp.ui.explore.TmpTripsScreen
import com.example.myapp.ui.myTrips.ChatScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.apiService.getTrip()
                Log.d("RETROFIT", "連線成功：$response")
            } catch (e: Exception) {
                Log.e("RETROFIT", "連線失敗", e)
            }
        }
        setContent {
            MyAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState() // 追蹤目前的畫面
    val currentRoute = currentBackStackEntry?.destination?.route // 取得目前畫面的路由

    val currentScreen = Screen.allScreens.find { it.route == currentRoute } // （自訂）包含所有畫面的清單，每個畫面應該有 .route 和 .label 屬性。
    val currentTitle = currentScreen?.label ?: "MyApp" // 取得對應目前 route 的畫面標題

    Scaffold(
        topBar = {
            TopBar(title = currentTitle)
        },
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Explore.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Explore.route) { ExploreScreen(navController) }
            composable(Screen.MyTrips.route) { MyTripsScreen(navController) }
            composable(Screen.Profile.route) { ProfileScreen() }
            composable("tmp_trips") { TmpTripsScreen() }
            composable("cities") { CityScreen() }
            composable("trip_details/{tripId}") { backStackEntry ->
                val tripId = backStackEntry.arguments?.getString("tripId") ?: ""
                TmpTripDetailsScreen(tripId = tripId, navController = navController)
            }

            composable("chatroom/{tripId}") { backStackEntry ->
                val tripId = backStackEntry.arguments?.getString("tripId") ?: ""
                ChatScreen(tripId = tripId, navController = navController)
            }
        }
    }
}
