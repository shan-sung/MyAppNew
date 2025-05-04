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
import com.example.myapp.ui.component.GridList
import com.example.myapp.ui.component.TripCard
import com.example.myapp.viewmodel.ExploreViewModel

@Composable
fun TmpTripsScreen(
    navController: NavController,
    viewModel: ExploreViewModel = viewModel()
) {
    val tmpTrips by viewModel.tmpTrips.collectAsState()

    Scaffold { innerPadding ->
        GridList(
            items = tmpTrips,
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) { trip ->
            TripCard(trip = trip, navController = navController)
        }
    }
}