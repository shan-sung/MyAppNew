package com.example.myapp.ui.myTrips

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapp.data.model.Trip
import com.example.myapp.viewmodel.MyTripsViewModel
import java.time.format.DateTimeFormatter

@Composable
fun MyTripsScreen(navController: NavController, viewModel: MyTripsViewModel = viewModel()) {
    val myTrips by viewModel.myTrips.collectAsState()

    LazyColumn {
        items(myTrips) { trip ->
            MyTripCard(trip = trip, navController = navController)
        }
    }
}

@Composable
fun MyTripCard(trip: Trip, navController: NavController) {
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable {
                navController.navigate("trip_details/${trip.id}")
            }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = trip.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${trip.startDate.format(dateFormatter)} - ${trip.endDate.format(dateFormatter)}（共 ${trip.days} 天）"
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "旅伴：${trip.members.joinToString("、")}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
