package com.example.myapp.ui.myTrips

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import com.example.myapp.data.model.AttractionPlan
import com.example.myapp.data.model.Trip
import com.example.myapp.viewmodel.MyTripsViewModel
import java.time.format.DateTimeFormatter


@Composable
fun TripDetailsScreen(
    tripId: String,
    navController: NavController,
    viewModel: MyTripsViewModel = viewModel()
) {
    val trips = viewModel.myTrips.collectAsState().value
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


@Composable
fun TripInfoSection(trip: Trip) {
    val preview = trip.members.take(3).joinToString(", ")
    val moreCount = trip.members.size - 3
    val memberText = if (moreCount > 0) "$preview... and $moreCount more" else preview
    val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd")
    Column {
        Text("Name: ${trip.name}")
        Text("Member: ${trip.members.size} · $memberText")
        Text("Budget: \$${trip.budget}")
        Text("Time: ${trip.startDate.format(formatter)} - ${trip.endDate.format(formatter)}")
        Text("Note: ${trip.note}")
    }
}

@Composable
fun AttractionCard(plan: AttractionPlan) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(plan.time)
                Text(plan.name, style = MaterialTheme.typography.titleMedium)
            }
            Button(onClick = { /* TODO: trigger navigation or map */ }) {
                Text("出發")
            }
        }
    }
}
