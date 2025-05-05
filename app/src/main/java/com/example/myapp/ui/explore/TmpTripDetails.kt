package com.example.myapp.ui.explore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapp.ui.myTrips.AttractionCard
import com.example.myapp.ui.myTrips.TripInfoSection
import com.example.myapp.viewmodel.TmpTripsViewModel


@Composable
fun TmpTripDetailsScreen(
    tripId: String,
    navController: NavController,
    viewModel: TmpTripsViewModel = viewModel()
) {
    val trips = viewModel.tmpTrips.collectAsState().value
    val trip = trips.find { it.id == tripId }

    var selectedDay by remember { mutableIntStateOf(1) }

    if (trip != null) {
        Column(modifier = Modifier.padding(16.dp)) {

            // 顯示基本資訊
            TripInfoSection(trip)

            Spacer(modifier = Modifier.height(16.dp))

            // 切換 Day1 ~ DayN
            Row {
                trip.dailyPlans.forEach { dayPlan ->
                    Button(
                        onClick = { selectedDay = dayPlan.day },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text("Day ${dayPlan.day}")
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Attraction 清單
            trip.dailyPlans.find { it.day == selectedDay }?.let { dayPlan ->
                dayPlan.attractions.forEach { item ->
                    AttractionCard(item)
                }
            }
        }
    } else {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("找不到行程", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navController.popBackStack() }) {
                Text("返回")
            }
        }

    }
}
