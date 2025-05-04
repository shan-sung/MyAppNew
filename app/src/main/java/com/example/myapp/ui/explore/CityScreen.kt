package com.example.myapp.ui.explore

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapp.ui.component.CityCard
import com.example.myapp.ui.component.GridList
import com.example.myapp.viewmodel.ExploreViewModel

@Composable
fun CityScreen(
    navController: NavController,
    viewModel: ExploreViewModel = viewModel()
) {
    val cities by viewModel.cities.collectAsState()

    Scaffold { innerPadding ->
        GridList(
            items = cities,
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) { city ->
            CityCard(city = city, navController = navController)
        }
    }
}